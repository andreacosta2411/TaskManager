package org.example;

import org.example.commands.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Logger;

public class ConsoleMenu {

    private final TaskManager taskManager;
    private final Scanner scanner;
    private final Logger log;

    private boolean running = true;

    private final Map<Integer, Command> commands = new TreeMap<>();

    public ConsoleMenu(TaskManager taskManager, Scanner scanner, Logger log) {
        this.taskManager = taskManager;
        this.scanner = scanner;
        this.log = log;

        // Registrazione comandi (Command Pattern)
        commands.put(1, new AddTaskCommand(taskManager, scanner, log));
        commands.put(2, new ListTasksCommand(taskManager));
        commands.put(3, new ListTasksAscCommand(taskManager));
        commands.put(4, new ListTasksDescCommand(taskManager));

        // Se esiste il metodo filterTasksByKeyword nel TaskManager, abilita questa riga:
        commands.put(5, new FilterTasksCommand(taskManager, scanner));

        commands.put(0, new ExitCommand(() -> running = false));
    }

    public void start() {
        while (running) {
            printMenu();
            int choice = readInt();

            Command cmd = commands.get(choice);
            if (cmd == null) {
                System.out.println("Scelta non valida.");
                log.warning("Scelta non valida inserita: " + choice);
                continue;
            }

            cmd.execute();
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("--- MENU ---");
        for (Map.Entry<Integer, Command> entry : commands.entrySet()) {
            System.out.println(entry.getKey() + ") " + entry.getValue().label());
        }
        System.out.print("Scelta: ");
    }

    private int readInt() {
        String s = scanner.nextLine().trim();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Input non numerico.");
            log.warning("Input non numerico inserito nel menu: " + s);
            return -1;
        }
    }
}