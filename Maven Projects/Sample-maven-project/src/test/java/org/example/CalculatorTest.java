package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calci;

    @BeforeEach
    void setup(){
        calci=new Calculator();
    }

    @AfterEach
    void tearDown(){
        calci=null;
    }

    @Test
    void addTest(){

        Assertions.assertEquals(50,calci.add(10,40));
    }

    @Test
    void divTest(){
        Assertions.assertEquals(4,calci.div(40,10));
        Assertions.assertThrows(Exception.class,()->calci.div(10,0));
    }

}
