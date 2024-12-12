package com.myportfolio.portfolioms.clients;

import com.myportfolio.portfolioms.dto.MutualFund;
import com.myportfolio.portfolioms.dto.Stock;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "stocks-service")
public interface StockServiceClient {

    @GetMapping("/stocks/{id}")
    Stock getStockById(@PathVariable int id);

}
