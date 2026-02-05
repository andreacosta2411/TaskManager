package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskGroupTest {

    @Test
    void groupHasName() {
        TaskGroup group = new TaskGroup("Università");
        assertEquals("Università", group.getName());
    }

    @Test
    void iteratorReturnsTasksInInsertionOrder() {
        TaskGroup group = new TaskGroup("G");

        group.addTask(TaskFactory.createTask("X"));
        group.addTask(TaskFactory.createTask("Y"));

        List<String> names = new ArrayList<>();
        for (Task t : group) {
            names.add(t.getName());
        }

        assertEquals(2, names.size());
        assertEquals("X", names.get(0));
        assertEquals("Y", names.get(1));
    }
}