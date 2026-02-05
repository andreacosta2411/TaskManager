package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    void newManagerIsEmpty() {
        // Creo un nuovo TaskManager
        TaskManager manager = new TaskManager();

        // Verifico che sia vuoto
        assertTrue(manager.isEmpty());
        assertEquals(0, manager.getTasks().size());
    }

    @Test
    void addTaskIncreasesSizeAndPreservesOrder() {
        // Creo il manager
        TaskManager manager = new TaskManager();

        // Aggiungo due task
        manager.addTask(TaskFactory.createTask("A"));
        manager.addTask(TaskFactory.createTask("B"));

        // Ottengo la lista dei task
        List<Task> tasks = manager.getTasks();

        // Verifico dimensione e ordine
        assertEquals(2, tasks.size());
        assertEquals("A", tasks.get(0).getName());
        assertEquals("B", tasks.get(1).getName());
    }

    @Test
    void getTasksReturnsUnmodifiableList() {
        // Creo il manager e aggiungo un task
        TaskManager manager = new TaskManager();
        manager.addTask(TaskFactory.createTask("A"));

        // Ottengo la lista
        List<Task> tasks = manager.getTasks();

        // Azione che tenta di modificare la lista
        Executable action = new Executable() {
            @Override
            public void execute() {
                tasks.add(TaskFactory.createTask("B"));
            }
        };

        // Verifico che venga lanciata un'eccezione
        assertThrows(UnsupportedOperationException.class, action);
    }
}