package com.example.stms.mapper;

import com.example.stms.dto.TaskRequest;
import com.example.stms.dto.TaskResponse;
import com.example.stms.entity.Task;

public class TaskMapper {
    public static Task toEntity(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        return task;
    }

    public static TaskResponse toResponse(Task task) {
        TaskResponse res = new TaskResponse();
        res.setId(task.getId());
        res.setTitle(task.getTitle());
        res.setDescription(task.getDescription());
        res.setStatus(task.getStatus().name());
        res.setStatusDescription(task.getStatus().getDescription());
        return res;
    }
}
