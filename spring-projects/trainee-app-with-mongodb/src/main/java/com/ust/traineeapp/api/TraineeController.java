package com.ust.traineeapp.api;


import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.service.TraineeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeController {

    @Autowired
   private TraineeServiceImpl traineeService;

    @PostMapping
    public Trainee saveTrainee(@RequestBody Trainee trainee){
       return traineeService.saveTrainee(trainee);
    }

    @GetMapping
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @GetMapping("/{id}")
    public Trainee getTraineeById(@PathVariable("id") String id){
        return traineeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainee(@PathVariable("id")String id){
        traineeService.deleteTrainee(id);
    }

    @PutMapping("/{id}/{trainee}")
    public Trainee updateTrainee(@PathVariable("id")String id,@RequestBody Trainee trainee){
        return traineeService.updateTrainee(id,trainee);
    }

}
