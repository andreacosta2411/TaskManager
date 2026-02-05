package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTest {

    @Test
    void factoryCreatesTaskWithName() {
        Task task = TaskFactory.createTask("Studiare Java");
        assertNotNull(task);
        assertEquals("Studiare Java", task.getName());
    }
}