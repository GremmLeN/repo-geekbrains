package ru.geekbrains;

import java.util.Calendar;

public class employee {

    private int id;
    private String fio;
    private int salary;
    private int birthDate;
    private static int seq;

    employee (String fio, int salary, int age) {
        this(salary, age);
        this.fio = fio;

    }

    employee (int salary, int age) {
        this.salary = salary;
        this.setBirthDate(age);
        this.id = setSeq();
    }

    public String getFio() {
        return this.fio;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - this.birthDate;
    }

    public int getId() {
        return this.id;
    }

    private void setBirthDate(int age) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        this.birthDate = year - age;
    }

    private int setSeq(){
        seq++;
        return seq;
    }

    void upSalary(int upSum) {
        if (this.getAge() > 45) this.salary = this.salary + upSum;
    }

}