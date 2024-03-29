package com.pavelhaimov.spring.mvc;

import com.pavelhaimov.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    @Size(min = 2, message = "name must be min 2 symbols")
    private String name;

    @NotBlank(message = "surname is required")
    private String surname;
    @Min(value = 500, message = "must be greater than 499")
    @Max(value = 1000, message = "must be less than 1001")
    private int salary;
    private String department;
    private Map<String, String> departments;
    private String carBrand;
    private Map<String, String> carBrands;
    private String[] languages;
    private Map<String, String> languagesList;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern XXX-XX-XX")
    private String phoneNumber;
    @CheckEmail
    private String email;

    public Employee() {
        departments = new HashMap<>();
        departments.put("IT","Information Technology");
        departments.put("HR","Human Resources");
        departments.put("Sales","Sales");

        carBrands = new HashMap<>();
        carBrands.put("BMW","BMW");
        carBrands.put("Audi","Audi");
        carBrands.put("Mercedes-Benz","MB");

        languagesList = new HashMap<>();
        languagesList.put("English","EN");
        languagesList.put("Deutsch","DE");
        languagesList.put("French","FR");

    }

    public Employee(String name, String surName, int salary, String department, String carBrand, String[] lang, String phoneNumber, String email) {
        this.name = name;
        this.surname = surName;
        this.salary = salary;
        this.department = department;
        this.carBrand = carBrand;
        this.languages = lang;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public Map<String, String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(Map<String, String> languagesList) {
        this.languagesList = languagesList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", lang=" + Arrays.toString(languages) +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
