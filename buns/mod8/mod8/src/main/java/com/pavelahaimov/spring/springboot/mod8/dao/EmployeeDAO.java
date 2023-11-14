package com.pavelahaimov.spring.springboot.mod8.dao;

import com.pavelahaimov.spring.springboot.mod8.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
