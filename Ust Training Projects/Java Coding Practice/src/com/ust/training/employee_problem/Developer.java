package com.ust.training.employee_problem;

public class Developer extends Employee {
private String PLanguage;

    public Developer(String name, int empId, float salary, String PLanguage) {
        super(name,empId, salary);
        this.PLanguage = PLanguage;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Programming Language : " +PLanguage);
    }

    @Override
    public void report() {
        super.report();
        System.out.println("I report to TL");
    }

    public String getPLanguage() {
        return PLanguage;
    }

    public void setPLanguage(String PLanguage) {
        this.PLanguage = PLanguage;
    }
}
