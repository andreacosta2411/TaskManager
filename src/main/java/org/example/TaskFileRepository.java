package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class TaskFileRepository {

    private final Path filePath;

    public TaskFileRepository(String fileName) {
        this.filePath = Paths.get(fileName);
    }
        // Carica i task dal file.
    public List<Task> load() throws IOException {
        List<Task> tasks = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return tasks; // nessun file = nessun task.
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line.trim();
                if (!name.isEmpty()) {
                    tasks.add(TaskFactory.createTask(name));
                }
            }
        }

        return tasks;
    }
    // Salva i Task sul File.
    public void save (List<Task> tasks) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        )) {
            for (Task t : tasks) {
                writer.write(t.getName());
                writer.newLine();
            }
        }
    }
}