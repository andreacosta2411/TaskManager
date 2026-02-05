package org.example;

public class SimpleTask implements Task {

    private String name;


    public SimpleTask(String name) {

        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }
}


