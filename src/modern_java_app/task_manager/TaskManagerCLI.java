package modern_java_app.task_manager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskManagerCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Task Manager Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Save Tasks to File");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            String input = sc.nextLine();

            switch (input) {
                case "1" -> {
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter task description: ");
                    String description = sc.nextLine();
                    Task task = new SimpleTask(taskManager.getTaskList().size() + 1, title, description, LocalDateTime.now().plusMinutes(5));
                    taskManager.addTask(task);
                    System.out.println("Task added.");
                }

                case "2" -> {
                    System.out.println("Listing Tasks: ");
                    taskManager.getTaskList().forEach(Task::displayDetails);
                }

                case "3" -> {
                    System.out.print("Enter task ID to mark completed: ");
                    String idStr = sc.nextLine();
                    int id = Integer.parseInt(idStr);
                    boolean found = false;
                    for (Task t : taskManager.getTaskList()) {
                        if (t.getId() == id) {
                            t.markCompleted();
                            System.out.println("Task marked as completed.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Task not found.");
                    }
                }
                case "4" -> {
                    TaskFileManager.saveTasks(taskManager.getTaskList());
                }

                case "5" -> {
                    exit = true;
                    System.out.println("Exiting Task Manager");
                }
                default -> System.out.println("Invalid option, please try again");
            }
        }

        taskManager.shutdownAutosave();
        sc.close();
    }
}
