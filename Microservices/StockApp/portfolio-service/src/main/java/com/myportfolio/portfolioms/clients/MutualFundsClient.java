package com.myportfolio.portfolioms.clients;

import com.myportfolio.portfolioms.dto.MutualFund;
import com.myportfolio.portfolioms.dto.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mutual-fund-service")
public interface MutualFundsClient {

    @GetMapping("/mutualFund/{id}")
    MutualFund getMutualFundById(@PathVariable int id);
}
