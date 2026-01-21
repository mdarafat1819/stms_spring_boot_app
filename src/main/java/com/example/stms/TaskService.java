package com.example.stms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository task_repo;

    public List<Task>getAllTask() {
        return task_repo.findAll();
    }
//    public Task getTask(Integer id) {
//         return task_repo.findById(id);
//     }
    public Task createTask(Task task) {
        return task_repo.save(task);
    }
}
