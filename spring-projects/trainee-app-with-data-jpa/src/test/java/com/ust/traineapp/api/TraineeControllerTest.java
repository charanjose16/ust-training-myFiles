package com.ust.traineapp.api;

import com.ust.traineapp.model.Trainee;
import com.ust.traineapp.service.TraineeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TraineeController.class)
class TraineeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TraineeServiceImpl traineeService;


    @Test
    void getAllTrainees() throws Exception {
        //given
        Trainee trainee=new Trainee(1,"Charan","Kerala", LocalDate.now());
        int id=1;

        //when
        Mockito.when(traineeService.getTraineeById(id)).thenReturn(trainee);

        //then
        mockMvc.perform(get("/api/v1/trainees/"+id))
                .andExpect(status().isOk())
                .andReturn();
    }
}