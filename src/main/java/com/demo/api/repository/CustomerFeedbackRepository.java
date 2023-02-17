package com.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.entity.CustomerFeedback;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Integer> {

}
