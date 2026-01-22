package com.example.stms;

import java.util.List;
import java.util.Optional;

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

@SpringBootApplication
@RestController
@RequestMapping("/tasks")
public class StmsApplication extends RuntimeException {

	public static void main(String[] args) {
		SpringApplication.run(StmsApplication.class, args);
	}

	// @Autowired
	private TaskService taskService;

	public StmsApplication(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public List<Task> getTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping("/{id}")
	public Optional<Task> getTask(@PathVariable Integer id) {
		return taskService.getTask(id);
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Integer id, @RequestBody Task task) {
		return taskService.updateTask(id, task);
	}

	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable Integer id) {
		return taskService.deletTask(id);
	}
}
