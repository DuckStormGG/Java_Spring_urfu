package com.pavelahaimov.spring.springboot.mod8_2.service;




import com.pavelahaimov.spring.springboot.mod8_2.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void  deleteEmployee(int id);
    public List<Employee> findAllByName(String name);
}
