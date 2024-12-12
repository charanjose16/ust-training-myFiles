package com.myportfolio.portfolioms.service;

import com.myportfolio.portfolioms.clients.MutualFundsClient;
import com.myportfolio.portfolioms.clients.StockServiceClient;
import com.myportfolio.portfolioms.dto.MutualFund;
import com.myportfolio.portfolioms.dto.Stock;
import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.repository.PortfolioRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    private static final Logger log = LoggerFactory.getLogger(PortfolioServiceImpl.class);
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private StockServiceClient stockServiceClient;

    @Autowired
    private MutualFundsClient mutualFundsClient;



    public Portfolio createPortfolio(Portfolio portfolio) {
        Portfolio savedPortfolio=portfolioRepository.save(portfolio);
        savedPortfolio.setTotalValue(fetchTotalValue(portfolio));
        return savedPortfolio;
    }

    public Portfolio getPortfolioById(String id) {
        Portfolio portfolio=portfolioRepository.findById(id).orElse(null);
        portfolio.setTotalValue(fetchTotalValue(portfolio));
        return portfolio;
    }

    public List<Portfolio> getAllPortfolio(){
        return portfolioRepository.findAll();
    }


    @CircuitBreaker(fallbackMethod = "fetchTotalValueFallback",name = "stocks-service-cb")
    public double fetchTotalValue(Portfolio portfolio){
        double totalValue=0;
        for(int stockId: portfolio.getStocks()){
            Stock stock=stockServiceClient.getStockById(stockId);
            totalValue+=stock.getPrice();
        }
        for(int mutualFundId : portfolio.getMutualFund()){

            MutualFund mutualFund=mutualFundsClient.getMutualFundById(mutualFundId);
            totalValue+=(mutualFund.getGrowthRate()* mutualFund.getAmountInvested());
        }
        return totalValue;

    }


//
//    public double fetchTotalValueFallback(Portfolio portfolio,Exception ex) {
//        log.error(ex.getMessage());
//        return 0;

//    }
}
