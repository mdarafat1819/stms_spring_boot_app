package com.example.stms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/tasks")
public class StmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StmsApplication.class, args);
	}

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task>getTasks() {
		return taskService.getAllTask();
	}
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

}
