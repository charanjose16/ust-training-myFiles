package com.ust.webapp.controller;

import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeRestController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping
    public List<Trainee> getTrainees(){
        return traineeService.viewTrainees();
    }

    @GetMapping("/{id}")
//    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Trainee> getTraineeById(@PathVariable("id") int id){
        if(traineeService.findTraineeById(id)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            Trainee trainee=traineeService.findTraineeById(id);
            return ResponseEntity.status(HttpStatus.OK).body(trainee);
        }

    }

    @PostMapping
//    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Trainee> saveTrainee(@RequestBody Trainee trainee){
        Trainee savedTrainee=traineeService.addTrainee(trainee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainee);
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public List<Trainee> deleteTrainee(@PathVariable("id") int id) {
        traineeService.deleteTrainee(id);
        return traineeService.viewTrainees();
    }

@PutMapping("/update/{id}")
@ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Trainee> updateTrainee(@RequestBody Trainee trainee,@PathVariable("id") int id){
        traineeService.updateTrainee(id,trainee.name(), trainee.location());
        return traineeService.viewTrainees();
    }

    @GetMapping("/search/{name}")
    public Trainee getTraineeByName(@PathVariable("name") String name){
        return traineeService.findTraineeByName(name);
    }

}
