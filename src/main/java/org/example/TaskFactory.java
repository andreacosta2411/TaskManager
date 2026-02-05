package org.example;

public class TaskFactory {

    public static Task createTask(String name) {
        return new SimpleTask(name);
    }
}
