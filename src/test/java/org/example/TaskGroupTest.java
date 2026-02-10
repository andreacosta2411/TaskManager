package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskGroupTest {

    @Test
    void iteratorTraversesNestedGroupsDepthFirst() {
        TaskGroup root = new TaskGroup("Root");
        root.addTask(TaskFactory.createTask("A"));

        TaskGroup sub = new TaskGroup("Sub");
        sub.addTask(TaskFactory.createTask("B"));
        sub.addTask(TaskFactory.createTask("C"));

        root.addTask(sub);
        root.addTask(TaskFactory.createTask("D"));

        List<String> names = new ArrayList<String>();
        for (Task t : root) {
            names.add(t.getName());
        }

        // Depth-first: A, Sub, B, C, D
        assertEquals(List.of("A", "Sub", "B", "C", "D"), names);
    }
}
