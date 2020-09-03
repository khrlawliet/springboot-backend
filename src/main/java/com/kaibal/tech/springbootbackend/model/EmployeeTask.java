package com.kaibal.tech.springbootbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee_task")
public class EmployeeTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String taskName;
	private String description;
	private Integer hourDuration;

	@JsonIgnore
	@ManyToOne
	private Employee employee;

}
