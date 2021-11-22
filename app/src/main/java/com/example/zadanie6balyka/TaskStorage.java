package com.example.zadanie6balyka;

import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();

    private final List<MainActivity.Task> tasks;

    public static TaskStorage getInstance() { return taskStorage; }

    public TaskStorage() {
        tasks = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            MainActivity.Task task = new MainActivity.Task();
            task.setName("Zadanie #" + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }
}