package modern_java_app.task_manager;

import java.time.LocalDateTime;

public final class TimedTask extends Task {

    private final LocalDateTime reminderTime;

    public TimedTask(int id, String title, String description, LocalDateTime dueDate, TaskStatus status, LocalDateTime reminderTime) {
        super(id, title, description, dueDate);
        this.reminderTime = reminderTime;
    }

    @Override
    public void displayDetails() {
        System.out.println("Timed Task: " + title + " | Due: " + dueDate + " | Reminder: " + reminderTime);
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }
}