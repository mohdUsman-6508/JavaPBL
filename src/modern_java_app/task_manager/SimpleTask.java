package modern_java_app.task_manager;

import java.time.LocalDateTime;

public  final class SimpleTask extends Task {

    public SimpleTask(int id, String title, String description, LocalDateTime dueDate) {
        super(id, title, description, dueDate);
    }

    @Override
    public void displayDetails() {
        System.out.println("Simple Task: " + title + " | Due: " + dueDate);
    }
}
