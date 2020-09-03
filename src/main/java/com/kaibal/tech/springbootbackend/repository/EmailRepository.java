package com.kaibal.tech.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaibal.tech.springbootbackend.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
