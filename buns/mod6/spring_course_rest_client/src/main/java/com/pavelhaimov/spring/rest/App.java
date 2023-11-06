package com.pavelhaimov.spring.rest;

import com.pavelhaimov.spring.rest.configuration.MyConfig;
import com.pavelhaimov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        System.out.println(communication.getEmployee(1));

//        Employee employee = new Employee("Sveta", "Sokolova", "IT", 1000);
//        employee.setId(7);
//        communication.saveEmployee(employee);

        communication.deleteEmployee(7);

    }
}
