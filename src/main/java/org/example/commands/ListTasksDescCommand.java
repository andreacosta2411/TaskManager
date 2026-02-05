package org.example.commands;

import org.example.Task;
import org.example.TaskManager;

import java.util.List;

public class ListTasksDescCommand implements Command {

    private final TaskManager taskManager;

    public ListTasksDescCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public String label() {
        return "Lista task (Z-A)";
    }

    @Override
    public void execute() {
        List<Task> tasks = taskManager.getTasksSortedByNameDesc();

        if (tasks.isEmpty()) {
            System.out.println("Nessun task presente.");
            return;
        }

        System.out.println("Lista task (Z-A):");
        for (Task t : tasks) {
            System.out.println("- " + t.getName());
        }
    }
}