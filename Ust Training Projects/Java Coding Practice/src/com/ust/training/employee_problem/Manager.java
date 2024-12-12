package com.ust.training.employee_problem;

public class Manager extends Employee {

    private int teamSize;

    public Manager(String name, int empId, double salary, int teamSize) {
        super(name, empId, salary);
        this.teamSize = teamSize;
    }

    public void displayDetails(){
      super.displayDetails();
        System.out.println("TeamSize : " +teamSize);

    }

    @Override
    public void report() {
        //super.report();
        System.out.println("I report to CEO");
        System.out.println("\n");
    }

    public int getTeamSize() {
        return teamSize;
    }


    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
