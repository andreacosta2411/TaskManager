package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addAll(List<Task> tasksToAdd) {
        tasks.addAll(tasksToAdd);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public List<Task> getTasksSortedByNameAsc() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getName))
                .collect(Collectors.toList());
    }

    public List<Task> getTasksSortedByNameDesc() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getName).reversed())
                .collect(Collectors.toList());
    }

    public List<Task> filterTasksByKeyword(String keyword) {
        return tasks.stream()
                .filter(t -> t.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}