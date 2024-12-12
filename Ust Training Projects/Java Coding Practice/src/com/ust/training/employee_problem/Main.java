package com.ust.training.employee_problem;

import com.ust.training.employee_problem.Employee;

public class Main {
    public static void main(String[] args) {

        Employee manager1=new Manager("Charan",34,35000,5);
        manager1.displayDetails();
        manager1.report();

        Employee developer1=new Developer("Senthil",39,45000,"python");
        developer1.displayDetails();
        developer1.report();
    }
    }


