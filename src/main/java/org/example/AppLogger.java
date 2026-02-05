package org.example;

import java.io.IOException;
import java.util.logging.*;

public class AppLogger {

    private static final Logger LOGGER = Logger.getLogger("TaskManagerLogger");
    private static boolean initialized = false;

    public static Logger getLogger() {
        if (!initialized) {
            setup();
            initialized = true;
        }
        return LOGGER;
    }

    private static void setup() {
        try {
            // Non voglio doppia stampa in console
            LOGGER.setUseParentHandlers(false);

            // Livello generale
            LOGGER.setLevel(Level.INFO);

            // Handler console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(consoleHandler);

            // Handler su file (crea app.log nella root del progetto quando esegui)
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);

        } catch (IOException e) {
            // Se fallisce il file logger, almeno non crasha:
            LOGGER.warning("Impossibile creare il file di log app.log");
        }
    }
}