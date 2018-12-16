package com.example.midterm;

public class Fish  implements Observer{
    private String id;

    public Fish(String id) {
        this.id = id;
    }

    private Subject subject;
    public Fish(String id, Subject subject){
        this.id = id;
        this.subject = subject;
        subject.register(this);
    }
    @Override
    public void update(int temp) {
        System.out.println("Fish "+ id + "receives temperature alert: " + temp);

    }

}

