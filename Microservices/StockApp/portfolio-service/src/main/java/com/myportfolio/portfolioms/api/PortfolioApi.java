package com.myportfolio.portfolioms.api;

import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.repository.PortfolioRepository;
import com.myportfolio.portfolioms.service.PortfolioService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioApi {

    @Autowired
    private PortfolioService portfolioService;

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio){
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(fallbackMethod = "getPortfolioByIdFallback",name = "stocks-service-cb")
    public Portfolio getPortfolioById(@PathVariable String id){
        return portfolioService.getPortfolioById(id);
    }

    @GetMapping
    public List<Portfolio> getAllPortfolio(){
        return portfolioService.getAllPortfolio();
    }


    public Portfolio getPortfolioByIdFallback(@PathVariable String id, Throwable error) {
        throw new RuntimeException("NOT FOUND",error);
    }



}
