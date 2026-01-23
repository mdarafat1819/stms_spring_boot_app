package com.example.stms;

import java.util.List;
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
   public Task getTask(Integer id) {
        return task_repo.findById(id).orElseThrow(()->
            new TaskNotFoundException(id)
        );
    }
    public Task createTask(Task task) {
        return task_repo.save(task);
    }
    public void deleteTask(Integer id) {
        if(!task_repo.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        task_repo.deleteById(id);
    }
   public Task updateTask(Integer id, Task updatedTask) {

    Task existingTask = task_repo.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id));
    existingTask.setTitle(updatedTask.getTitle());
    existingTask.setDescription(updatedTask.getDescription());
    existingTask.setStatus(updatedTask.getStatus());

    return task_repo.save(existingTask);
}

}
