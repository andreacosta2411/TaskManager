package org.example;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    //Punto di ingresso dell'applicazione.
    public static void main(String[] args) {

        Logger log = AppLogger.getLogger();
        log.info("Avvio applicazione TaskManager");

        TaskManager taskManager = new TaskManager();
        TaskFileRepository repo = new TaskFileRepository("tasks.txt");

        // Caricamenti da file (Java I/O)
        try {
            List<Task> loaded = repo.load();
            taskManager.addAll(loaded);
            log.info("Caricati " + loaded.size() + " task da tasks.txt");
        } catch (IOException e) {
            // niente stack trace
            log.warning("Impossibile caricare tasks.txt");
        }

        ConsoleMenu menu = new ConsoleMenu(taskManager, repo);
        menu.start();

        log.info("Chiusura applicazione TaskManager");
    }
}