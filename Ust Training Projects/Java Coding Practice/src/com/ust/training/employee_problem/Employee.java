package com.ust.training.employee_problem;

public abstract class Employee {
    private String name;
    private int empId;
    private double salary;

    public Employee(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println(this.getClass().getSimpleName()+" Details : ");
        System.out.println("Name : " +name);
        System.out.println("Employee Id : " +empId);
        System.out.println("Salary : " +salary);
}

public void report(){

}




}
