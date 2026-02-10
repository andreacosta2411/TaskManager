package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Pattern Composite + Iterator (custom)
public class TaskGroup implements Task, Iterable<Task> {

    private final String name;

    // Lista interna dei task nel gruppo (può contenere anche altri TaskGroup)
    private final List<Task> tasks = new ArrayList<>();

    public TaskGroup(String name) {
        this.name = name;
    }

    // Aggiunge un task al gruppo.
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Iterator "vero":
     * - attraversa anche TaskGroup annidati (Composite)
     * - ordine: depth-first
     */
    @Override
    public Iterator<Task> iterator() {
        return new DepthFirstIterator(this);
    }

    // Iterator custom (depth-first) per il composite
    private static final class DepthFirstIterator implements Iterator<Task> {
        private final ArrayDeque<Iterator<Task>> stack = new ArrayDeque<>();
        private Task next;

        private DepthFirstIterator(TaskGroup root) {
            stack.push(root.tasks.iterator());
            advance();
        }

        private void advance() {
            next = null;

            while (!stack.isEmpty()) {
                Iterator<Task> it = stack.peek();

                if (!it.hasNext()) {
                    stack.pop();
                    continue;
                }

                Task candidate = it.next();
                next = candidate;

                // Java 8: instanceof + cast
                if (candidate instanceof TaskGroup) {
                    TaskGroup group = (TaskGroup) candidate;
                    stack.push(group.tasks.iterator());
                }
                return;
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Task next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            Task current = next;
            advance();
            return current;
        }
    }
}
