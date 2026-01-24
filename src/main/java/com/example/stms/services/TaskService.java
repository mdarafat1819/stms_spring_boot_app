package com.example.stms.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.stms.entity.Task;
import com.example.stms.exceptions.TaskNotFoundException;
import com.example.stms.repository.TaskRepository;

@Service
public class TaskService {
   // @Autowired
    private TaskRepository taskRepo;
    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task>getAllTasks() {
        return taskRepo.findAll();
    }
   public Task getTask(Integer id) {
        return taskRepo.findById(id).orElseThrow(()->
            new TaskNotFoundException(id)
        );
    }
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }
    public void deleteTask(Integer id) {
        if(!taskRepo.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepo.deleteById(id);
    }
   public Task updateTask(Integer id, Task updatedTask) {

    Task existingTask = taskRepo.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id));
    existingTask.setTitle(updatedTask.getTitle());
    existingTask.setDescription(updatedTask.getDescription());
    existingTask.setStatus(updatedTask.getStatus());

    return taskRepo.save(existingTask);
}

}
