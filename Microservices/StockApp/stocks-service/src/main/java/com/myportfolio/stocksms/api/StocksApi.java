package com.myportfolio.stocksms.api;

import com.myportfolio.stocksms.dto.StockInputList;
import com.myportfolio.stocksms.model.Stock;
import com.myportfolio.stocksms.repository.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StocksApi {

    @Autowired
    private StocksRepository stocksRepository;

    @PostMapping
    private Stock saveStock(@RequestBody Stock stock){
        return stocksRepository.save(stock);
    }

    @GetMapping("/{id}")
    public Stock getStocksById(@PathVariable int id){
        return stocksRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Stock> getAllStocks(){
        return stocksRepository.findAll();
    }

    @PostMapping("/all")
    public List<Stock> findStocksById(@RequestBody StockInputList stockInputList){
        return  stocksRepository.findAllById(stockInputList.ids());
    }


}
