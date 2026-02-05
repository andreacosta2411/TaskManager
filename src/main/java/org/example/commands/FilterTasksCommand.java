package org.example.commands;

import org.example.Task;
import org.example.TaskManager;

import java.util.List;
import java.util.Scanner;

public class FilterTasksCommand implements Command {

    private final TaskManager taskManager;
    private final Scanner scanner;

    public FilterTasksCommand(TaskManager taskManager, Scanner scanner) {
        this.taskManager = taskManager;
        this.scanner = scanner;
    }

    @Override
    public String label() {
        return "Cerca task per keyword";
    }

    @Override
    public void execute() {
        System.out.print("Inserisci keyword: ");
        String keyword = scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Keyword non valida.");
            return;
        }

        List<Task> results = taskManager.filterTasksByKeyword(keyword);

        if (results.isEmpty()) {
            System.out.println("Nessun risultato.");
            return;
        }

        System.out.println("Risultati:");
        for (Task t : results) {
            System.out.println("- " + t.getName());
        }
    }
}