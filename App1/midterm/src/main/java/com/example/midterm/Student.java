package com.example.midterm;

public class Student implements Observer{
    private String id;

    public Student(String id) {
        this.id = id;

    }

    private Subject subject;

    public Student(String id, Subject subject){
        this.id = id;
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void update(int temp) {
        System.out.println("Student "+ id + "receives temperature alert: " + temp );

    }

}

