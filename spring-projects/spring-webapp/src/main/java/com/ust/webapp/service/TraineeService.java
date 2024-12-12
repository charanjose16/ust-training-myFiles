package com.ust.webapp.service;

import com.ust.webapp.model.Trainee;
import com.ust.webapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {

    @Autowired
    TraineeRepository repository;

    public Trainee addTrainee(Trainee trainee){
        repository.addTrainee(trainee);
        return trainee;
    }
    public List<Trainee> viewTrainees(){
        List<Trainee> traineeList= repository.getAllTrainees();
        return repository.getAllTrainees();
    }

    public void deleteTrainee(int id){
        repository.deleteTrainee(id);
    }

    public void updateTrainee(int id,String name,String location){
repository.updateTrainee(id,name,location);
    }

    public Trainee findTraineeById(int id){
        return repository.getTraineeById(id);
    }

    public  Trainee findTraineeByName(String name){
        return repository.getTraineeByName(name);
    }
}
