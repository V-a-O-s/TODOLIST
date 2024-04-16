package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/todo")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;

	@CrossOrigin
	@Operation
	@GetMapping({"/v1","/v2"})
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@CrossOrigin
	@Operation
	@PostMapping({"/v1/tasks","/v2/tasks"})
	public ResponseEntity<String> addTask(@RequestBody String taskdescription) {
		
		Task task = new Task();
		task.setTaskdescription(taskdescription);
		taskRepository.save(task);

		return ResponseEntity.ok("Created task with id:"+task.getId()+", taskdescription:"+task.getTaskdescription()+"");
	}

	@CrossOrigin
	@Operation
    @PostMapping("/v1/delete")
    public ResponseEntity<String> delTask(@RequestBody String id) {
		System.out.println(id);
        try {
            int taskId = Integer.parseInt(id);
            Optional<Task> taskToDelete = taskRepository.findById(taskId);
            if (taskToDelete.isPresent()) {
                taskRepository.delete(taskToDelete.get());
                return ResponseEntity.ok("Task '" + taskToDelete.get().getTaskdescription() + "' has been deleted");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid task ID format");
        }
    }

	@CrossOrigin
	@Operation
    @PostMapping("/v2/delete")
    public ResponseEntity<String> delTaskV2(@RequestBody String id) {
		System.out.println(id+" api v2");
        try {
            int taskId = Integer.parseInt(id);
            Optional<Task> taskToDelete = taskRepository.findById(taskId);
            if (taskToDelete.isPresent()) {
                taskRepository.delete(taskToDelete.get());
                return ResponseEntity.ok("Task '" + taskToDelete.get().getTaskdescription() + "' has been deleted");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid task ID format");
        }
    }

}
