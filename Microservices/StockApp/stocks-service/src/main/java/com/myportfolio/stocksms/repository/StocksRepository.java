package com.myportfolio.stocksms.repository;

import com.myportfolio.stocksms.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<Stock,Integer> {
}
