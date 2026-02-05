package org.example.commands;

import org.example.TaskFactory;
import org.example.TaskManager;

import java.util.Scanner;
import java.util.logging.Logger;

public class AddTaskCommand implements Command {

    private final TaskManager taskManager;
    private final Scanner scanner;
    private final Logger log;

    public AddTaskCommand(TaskManager taskManager, Scanner scanner, Logger log) {
        this.taskManager = taskManager;
        this.scanner = scanner;
        this.log = log;
    }

    @Override
    public String label() {
        return "Aggiungi task";
    }

    @Override
    public void execute() {
        System.out.print("Inserisci il nome del task: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Nome non valido.");
            log.warning("Tentativo di aggiungere task con nome vuoto");
            return;
        }

        taskManager.addTask(TaskFactory.createTask(name));
        System.out.println("Task aggiunto!");
        log.info("Task aggiunto: " + name);
    }
}