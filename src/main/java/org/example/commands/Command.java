package org.example.commands;

public interface Command {
    // Nome che appare nel menu.
    String label();

    // Azione eseguita quando l’utente seleziona la voce.
    void execute();
}