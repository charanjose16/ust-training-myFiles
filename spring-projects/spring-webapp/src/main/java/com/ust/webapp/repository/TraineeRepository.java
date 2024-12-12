package com.ust.webapp.repository;

import com.ust.webapp.model.Trainee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TraineeRepository {
    List<Trainee> trainees=new ArrayList<>();

    @PostConstruct
    void init(){
        Trainee trainee1=new Trainee(1,"Charan","Chennai");
        trainees.add(trainee1);
        Trainee trainee2=new Trainee(2,"Senthil","Chennai");
        trainees.add(trainee2);
    }

    public List<Trainee> getAllTrainees(){
        return trainees;
    }

    public void addTrainee(Trainee trainee){
        trainees.add(trainee);
    }

    public void deleteTrainee(int id){
        trainees.removeIf(trainee -> trainee.id()==id);
    }

    public Trainee getTraineeById(int id){
        return trainees.stream().filter(i->i.id()==id).findFirst().orElse(null);
    }

    public void updateTrainee(int id,String name,String location){
        Trainee trainee=new Trainee(id,name,location);
        deleteTrainee(id);
        addTrainee(trainee);

    }
    public Trainee getTraineeByName(String name){
        return trainees.stream().filter(i->i.name().equals(name)).findFirst().orElse(null);
    }
}
