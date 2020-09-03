package com.kaibal.tech.springbootbackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaibal.tech.springbootbackend.model.EmployeeTask;

@Repository
public interface EmployeeTaskRespository extends JpaRepository<EmployeeTask, Long> {

	Page<EmployeeTask> findByEmployeeId(Long id, Pageable pageable);


}
