package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleMenu {

    private final TaskManager taskManager;
    private final TaskFileRepository repo;
    private final Scanner scanner;
    private final Logger log;

    public ConsoleMenu(TaskManager taskManager, TaskFileRepository repo) {
        this.taskManager = taskManager;
        this.repo = repo;
        this.scanner = new Scanner(System.in);
        this.log = AppLogger.getLogger();
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt();

            switch (choice) {
                case 1:
                    addTask();
                    break;

                case 2:
                    // Lista "normale" (ordine di inserimento)
                    printTasks(taskManager.getTasks());
                    log.info("Lista task visualizzata (ordine di inserimento)");
                    break;

                case 3:
                    // Lista A-Z (Stream API nel TaskManager)
                    printTasks(taskManager.getTasksSortedByNameAsc());
                    log.info("Lista task visualizzata (A-Z)");
                    break;

                case 4:
                    // Lista Z-A (Stream API nel TaskManager)
                    printTasks(taskManager.getTasksSortedByNameDesc());
                    log.info("Lista task visualizzata (Z-A)");
                    break;

                case 0:
                    log.info("Uscita selezionata dall'utente");
                    running = false;
                    System.out.println("Ciao!");
                    break;

                default:
                    System.out.println(" Scelta non valida. Usa 1, 2, 3, 4 o 0 per avviare il programma.");
                    log.warning("Scelta non valida inserita: " + choice);
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1) Aggiungi task");
        System.out.println("2) Lista task (ordine inserimento)");
        System.out.println("3) Lista task (A-Z)");
        System.out.println("4) Lista task (Z-A)");
        System.out.println("0) Esci");
        System.out.print("Scelta: ");
    }

    private int readInt() {
        String input = scanner.nextLine().trim();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            log.warning("Input non numerico inserito nel menu: " + input);
            return -1;
        }
    }

    private void addTask() {
        System.out.print("Inserisci il nome del task: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println(" Nome non valido: non può essere vuoto.");
            log.warning("Tentativo di inserimento task con nome vuoto");
            return;
        }

        taskManager.addTask(TaskFactory.createTask(name));
        log.info("Task aggiunto: " + name);
        System.out.println(" Task aggiunto con successo.");

        // Salvataggio su file (Java I/O)
        try {
            repo.save(taskManager.getTasks());
            log.info("Salvati " + taskManager.getTasks().size() + " task su tasks.txt");
        } catch (IOException e) {
            log.warning("Impossibile salvare tasks.txt");
            System.out.println(" Attenzione: non sono riuscito a salvare su file.");
        }
    }

    private void printTasks(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println(" Nessun task presente.");
            return;
        }

        System.out.println("\nLista task:");
        for (Task task : tasks) {
            System.out.println("- " + task.getName());
        }
    }
}