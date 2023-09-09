package com.example.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springjpa.entity.Employee;

public interface StudentRepository extends JpaRepository<Employee,Integer> {

}
