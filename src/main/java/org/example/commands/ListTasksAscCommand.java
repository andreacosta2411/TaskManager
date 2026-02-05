package org.example.commands;

import org.example.Task;
import org.example.TaskManager;

import java.util.List;

public class ListTasksAscCommand implements Command {

    private final TaskManager taskManager;

    public ListTasksAscCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public String label() {
        return "Lista task (A-Z)";
    }

    @Override
    public void execute() {
        List<Task> tasks = taskManager.getTasksSortedByNameAsc();

        if (tasks.isEmpty()) {
            System.out.println("Nessun task presente.");
            return;
        }

        System.out.println("Lista task (A-Z):");
        for (Task t : tasks) {
            System.out.println("- " + t.getName());
        }
    }
}