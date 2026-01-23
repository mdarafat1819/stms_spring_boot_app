package com.example.stms;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@SpringBootApplication
@RestController
@RequestMapping("/tasks")
public class StmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StmsApplication.class, args);
	}

	// @Autowired
	private TaskService taskService;

	public StmsApplication(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public List<TaskResponse> getTasks() {
		return taskService.getAllTasks().stream().map(TaskMapper::toResponse).toList();
	}

	@GetMapping("/{id}")
	public TaskResponse getTask(@PathVariable Integer id) {
		return TaskMapper.toResponse(taskService.getTask(id));
	}

	@PostMapping
	public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
		Task task = TaskMapper.toEntity(request);
		return TaskMapper.toResponse(taskService.createTask(task));
	}

	@PutMapping("/{id}")
	public TaskResponse updateTask(@PathVariable Integer id, @Valid @RequestBody TaskRequest request) {
		Task task = TaskMapper.toEntity(request);
		return TaskMapper.toResponse(taskService.updateTask(id, task));
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Integer id) {
		taskService.deleteTask(id);
	}
}
