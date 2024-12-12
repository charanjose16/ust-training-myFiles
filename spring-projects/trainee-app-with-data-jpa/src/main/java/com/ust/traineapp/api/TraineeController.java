package com.ust.traineapp.api;

import com.ust.traineapp.model.Trainee;
import com.ust.traineapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500/"})
@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Trainee saveTrainee(@RequestBody Trainee trainee){
       return traineeService.saveTrainee(trainee);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee getTraineeById(@PathVariable("id") int id){
        return traineeService.getTraineeById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteTrainee(@PathVariable("id") int id){
        traineeService.deleteTrainee(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee updateTrainee(@PathVariable("id") int id,@RequestBody Trainee trainee){
        return traineeService.updateTrainee(id,trainee);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee findTraineeByName(@PathVariable("name") String name){
        return traineeService.findTraineeByName(name);
    }

    @GetMapping("/location/{location}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Trainee> findTraineeByLocation(@PathVariable("location") String location){
        return traineeService.findTraineeByLocation(location);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<Trainee> findByMonthAndYear(@PathVariable("month") int month,@PathVariable("year")int year){
        return traineeService.findTraineeByMonthAndYear(month,year);
    }

}
