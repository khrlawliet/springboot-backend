package com.kaibal.tech.springbootbackend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;
	private String lastName;
	private String middleName;
	private String emailId;
	private String test;

	@OneToMany(mappedBy = "employee")
	private Set<Credential> credentials;
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private Set<EmployeeTask> employeeTask;


}
