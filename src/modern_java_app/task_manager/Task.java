package modern_java_app.task_manager;

import java.time.LocalDateTime;

public abstract sealed class Task permits TimedTask, SimpleTask {

    protected final int id;
    protected String title;
    protected String description;
    protected LocalDateTime dueDate;
    protected TaskStatus status;

    public Task(int id, String title, String description, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = TaskStatus.PENDING;
    }

    public abstract void displayDetails();

    public void markCompleted() {
        this.status = TaskStatus.COMPLETED;
    }

    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return title;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public TaskStatus getStatus() {
        return status;
    }
}

