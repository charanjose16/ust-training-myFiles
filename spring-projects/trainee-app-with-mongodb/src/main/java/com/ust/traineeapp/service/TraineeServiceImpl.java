package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;

        @PreAuthorize("hasRole('ADMIN')")
    public Trainee saveTrainee(Trainee trainee) {
        if(trainee.getId()!=null && traineeRepository.existsById(trainee.getId())){
            throw  new RuntimeException("Trainee with id "+trainee.getId()+" already exist");
        }
        UUID uuid=UUID.randomUUID();
        trainee.setId(uuid.toString());
        return traineeRepository.save(trainee);
    }

    public Trainee findById(String id) {
        return traineeRepository.findById(id).orElse(null);
    }

    @PreAuthorize("hasRole('USER')")
    public List<Trainee> getAllTrainees() {
        return traineeRepository.findAll();
    }

    public void deleteTrainee(String id) {
        traineeRepository.deleteById(id);
    }

    public Trainee updateTrainee(String id,Trainee trainee) {
        if(!traineeRepository.existsById(id)){
            throw  new RuntimeException("Trainee with id "+trainee.getId()+" not found");
        }
        return traineeRepository.save(trainee);
    }
}
