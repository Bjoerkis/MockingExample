package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest implements EmployeeRepository {


    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        Employee steve = new Employee("1", 500);
        employees.add(steve);
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
