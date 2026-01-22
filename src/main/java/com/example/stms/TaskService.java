package com.example.stms;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
   // @Autowired
    private TaskRepository task_repo;
    public TaskService(TaskRepository taskRepo) {
        task_repo = taskRepo;
    }

    public List<Task>getAllTasks() {
        return task_repo.findAll();
    }
   public Optional<Task> getTask(Integer id) {
        return task_repo.findById(id);
    }
    public Task createTask(Task task) {
        return task_repo.save(task);
    }
    public String deletTask(Integer id) {
        if(!task_repo.existsById(id)) {
            throw new RuntimeException("Task not found with id: " + id);
        }
        task_repo.deleteById(id);
        return "Successfully removed";
    }
   public Task updateTask(Integer id, Task updatedTask) {

    Task existingTask = task_repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    existingTask.setStatus(updatedTask.getStatus());

    return task_repo.save(existingTask);
}

}
