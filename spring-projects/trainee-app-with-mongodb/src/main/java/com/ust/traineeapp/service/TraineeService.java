package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;

import java.util.List;

public interface TraineeService {
    Trainee saveTrainee(Trainee trainee);
    Trainee findById(String id);
    List<Trainee> getAllTrainees();
    void deleteTrainee(String id);
    Trainee updateTrainee(String id,Trainee trainee);
}
