package modern_java_app.task_manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TaskFileManager {

    private static final Path FILE_PATH = Paths.get("src/modern_java_app/task_manager/tasks.txt");

    public static void saveTasks(List<Task> taskList) {
        String data = taskList.stream()
                .map(task -> task.getId() + ";" + task.getTitle() + ";" + task.getStatus() + ";" + task.getDueDate())
                .collect(Collectors.joining(System.lineSeparator()));

        try {
            Files.writeString(FILE_PATH, data);
            System.out.println("Tasks saved to file");
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

}
