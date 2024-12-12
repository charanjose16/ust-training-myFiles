package com.ust.webapp.controller;

import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TraineeController {

    @Autowired
    TraineeService service;

    @PostMapping("/add-trainee")
    public String addTrainee(@ModelAttribute("trainee") Trainee trainee,Model model){
        service.addTrainee(trainee);
        model.addAttribute("traineesList",service.viewTrainees());
        return "view.jsp";
    }

    @GetMapping("/")
    public String viewTrainee(){
        return "index.jsp";
    }

    @PostMapping("/delete-trainee")
    public String deleteTrainee(@RequestParam("id") int id, Model model) {
        service.deleteTrainee(id);
        model.addAttribute("traineesList", service.viewTrainees());
        return "view.jsp";
    }

    @PostMapping ("/find-trainee")
    public String getTrainee(Model model,@RequestParam("findId") int id){
        Trainee trainee=service.findTraineeById(id);
        model.addAttribute("trainee",trainee);
        return "findTrainee.jsp";
    }
}
