package org.example.commands;

public class ExitCommand implements Command {

    private final Runnable onExit;

    public ExitCommand(Runnable onExit) {
        this.onExit = onExit;
    }

    @Override
    public String label() {
        return "Esci";
    }

    @Override
    public void execute() {
        onExit.run();
        System.out.println("Uscita...");
    }
}