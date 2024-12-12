package com.myportfolio.mutualfundsms.api;

import com.myportfolio.mutualfundsms.model.MutualFund;
import com.myportfolio.mutualfundsms.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutualFund")
public class MutualFundApi {


    @Autowired
    private MutualFundRepository mutualFundRepository;

    @PostMapping
    public MutualFund createMutualFund(@RequestBody MutualFund mutualFund){
        return mutualFundRepository.save(mutualFund);
    }

    @GetMapping("/{id}")
    public MutualFund getMutualFundById(@PathVariable int id){
        return mutualFundRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<MutualFund> getAllMutualFunds(){
        return mutualFundRepository.findAll();
    }

}
