package org.example.commands;

import org.example.Task;
import org.example.TaskManager;

import java.util.List;

public class ListTasksCommand implements Command {

    private final TaskManager taskManager;

    public ListTasksCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public String label() {
        return "Lista task (ordine inserimento)";
    }

    @Override
    public void execute() {
        List<Task> tasks = taskManager.getTasks();

        if (tasks.isEmpty()) {
            System.out.println("Nessun task presente.");
            return;
        }

        System.out.println("Lista task:");
        for (Task t : tasks) {
            System.out.println("- " + t.getName());
        }
    }
}