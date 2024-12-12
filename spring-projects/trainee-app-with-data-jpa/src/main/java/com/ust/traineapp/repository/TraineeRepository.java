package com.ust.traineapp.repository;

import com.ust.traineapp.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TraineeRepository extends JpaRepository<Trainee,Integer> {

//    @Query("from Trainee where name=:name")
    Optional<Trainee> findByName(String name);
//
//    @Query("from Trainee where location=:location")
    List<Trainee> findByLocation(String location);

    @Query(value = "SELECT * FROM trainee_db WHERE EXTRACT(MONTH FROM joined_date) = :month AND EXTRACT(YEAR FROM joined_date) = :year", nativeQuery = true)
    public List<Trainee> getAllByMonthAndYear(int month, int year);

}
