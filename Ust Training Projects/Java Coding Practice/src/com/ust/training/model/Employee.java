package com.ust.training.model;

public class Employee extends PersonOop{

    private long empId;
    private float salary;


    public Employee(String name, int age, String location, long empId, float salary) {
        super(name, age, location);
        this.empId = empId;
        this.salary = salary;
    }

    public Employee() {
    }
    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }


}
