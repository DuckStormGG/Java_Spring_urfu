package com.pavelahaimov.spring.springboot.mod8_2.dao;



import com.pavelahaimov.spring.springboot.mod8_2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByName(String name);
}
