package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger log = AppLogger.getLogger();
        log.info("Avvio applicazione TaskManager");

        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        ConsoleMenu menu = new ConsoleMenu(taskManager, scanner, log);
        menu.start();

        log.info("Chiusura applicazione TaskManager");
    }
}