package com.ust.traineapp.service;

import com.ust.traineapp.exception.RecordNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceImplTest {

    @Autowired
    TraineeServiceImpl traineeService;

    @Test
    void getTraineeById(){
        var id=1;
        Assertions.assertDoesNotThrow(()->traineeService.getTraineeById(id));
        Assertions.assertThrows(RecordNotFoundException.class,()->traineeService.getTraineeById(100));
    }
}
