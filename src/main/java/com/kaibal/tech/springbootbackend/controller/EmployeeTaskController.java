package com.kaibal.tech.springbootbackend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaibal.tech.springbootbackend.exception.ResourceNotFoundException;
import com.kaibal.tech.springbootbackend.model.Employee;
import com.kaibal.tech.springbootbackend.model.EmployeeTask;
import com.kaibal.tech.springbootbackend.repository.EmployeeRepository;
import com.kaibal.tech.springbootbackend.repository.EmployeeTaskRespository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeTaskController {

	@Autowired
	private EmployeeTaskRespository employeeTaskRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/employees/{id}/tasks")
	public EmployeeTask createEmployeeTask(@PathVariable Long id, @RequestBody EmployeeTask employeeTask) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exist with id : " + id));
		employeeTask.setEmployee(employee);
		return employeeTaskRepository.save(employeeTask);
	}

	@PutMapping("/employees/{id}/tasks/{taskId}") 
	public ResponseEntity<EmployeeTask> updateEmployeeTask(@PathVariable Long taskId,
			@RequestBody EmployeeTask employeeTaskDetails) {
		EmployeeTask employeeTask = employeeTaskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exist with id : " + taskId));
		employeeTask.setTaskName(employeeTaskDetails.getTaskName());
		employeeTask.setHourDuration(employeeTaskDetails.getHourDuration());
		employeeTask.setDescription(employeeTaskDetails.getDescription());
		EmployeeTask updatedEmployee = employeeTaskRepository.save(employeeTask);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}/tasks/{taskId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeTask(@PathVariable Long taskId) {
		EmployeeTask employeeTask = employeeTaskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exist with id : " + taskId));
		employeeTaskRepository.delete(employeeTask);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
