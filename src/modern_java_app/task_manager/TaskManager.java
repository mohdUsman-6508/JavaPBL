package modern_java_app.task_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskManager {
    private final List<Task> taskList;
    private final ScheduledExecutorService scheduler;

    public TaskManager(){
        taskList=new ArrayList<>();
        scheduler= Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(()->{
            System.out.println("Autosaving tasks...");
            TaskFileManager.saveTasks(taskList);
        },1,2, TimeUnit.MINUTES);
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public List<Task> getTaskList(){
        return taskList;
    }

    public void shutdownAutosave(){
        scheduler.shutdown();
    }
}
