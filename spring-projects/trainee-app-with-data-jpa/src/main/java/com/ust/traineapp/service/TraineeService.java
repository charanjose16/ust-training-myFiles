package com.ust.traineapp.service;

import com.ust.traineapp.model.Trainee;

import java.util.List;

public interface TraineeService {

    Trainee saveTrainee(Trainee trainee);
    Trainee getTraineeById(int id);
    void deleteTrainee(int id);
    List<Trainee> getAllTrainees();
    Trainee updateTrainee(int id,Trainee trainee);
    Trainee findTraineeByName(String name);
    List<Trainee> findTraineeByLocation(String name);
    List<Trainee> findTraineeByMonthAndYear(int month,int year);
}
