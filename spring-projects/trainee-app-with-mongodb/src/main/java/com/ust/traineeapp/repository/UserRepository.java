package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, BigInteger> {
    Optional<UserModel> findByUsername(String username);
}
