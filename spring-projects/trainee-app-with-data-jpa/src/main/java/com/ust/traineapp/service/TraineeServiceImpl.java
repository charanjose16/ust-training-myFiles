package com.ust.traineapp.service;

import com.ust.traineapp.exception.RecordNotFoundException;
import com.ust.traineapp.exception.TraineeAlreadyPresentException;
import com.ust.traineapp.model.Project;
import com.ust.traineapp.model.Trainee;
import com.ust.traineapp.repository.ProjectRepository;
import com.ust.traineapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepo;
    @Autowired
    private ProjectRepository projectRepository;
    public Trainee saveTrainee(Trainee trainee) {
        if(traineeRepo.existsById(trainee.getId())){
            throw new TraineeAlreadyPresentException("Trainee with ID "+trainee.getId()+" Already Present");
        }
        Trainee savedTrainee=null;
//        Project project = projectRepository.findById(trainee.getProject().getId()).orElse(null);
//        Trainee savedTrainee;
//        if (project != null) {
//            trainee.setProject(project);
//            savedTrainee = traineeRepo.save(trainee);
//            project.getTrainees().add(savedTrainee);
//            projectRepository.save(project);
//        }
//        else {
            savedTrainee = traineeRepo.save(trainee);
//        }


        return savedTrainee;

    }

    public Trainee getTraineeById(int id) {
        return traineeRepo.findById(id).orElseThrow(()->new RecordNotFoundException("Trainee with id : "+id+" not found"));
    }

    public void deleteTrainee(int id) {
traineeRepo.deleteById(id);
    }

    public List<Trainee> getAllTrainees() {
        return traineeRepo.findAll();
    }

    public Trainee updateTrainee(int id,Trainee trainee) {
        Trainee traineeToUpdate=getTraineeById(id);
        if(trainee.getName()!=null && !trainee.getName().isEmpty()){
            traineeToUpdate.setName(trainee.getName());
        }
        if(trainee.getLocation()!=null && !trainee.getLocation().isEmpty()){
            traineeToUpdate.setLocation(trainee.getLocation());
        }
        if(trainee.getJoinedDate()!=null){
            traineeToUpdate.setJoinedDate(trainee.getJoinedDate());
        }
        return traineeRepo.save(traineeToUpdate);
    }

    public Trainee findTraineeByName(String name) {
        return traineeRepo.findByName(name).orElse(null);
    }

    public List<Trainee> findTraineeByLocation(String location) {
        return traineeRepo.findByLocation(location);
    }

    public List<Trainee> findTraineeByMonthAndYear(int month, int year) {
        return traineeRepo.getAllByMonthAndYear(month,year);
    }
}
