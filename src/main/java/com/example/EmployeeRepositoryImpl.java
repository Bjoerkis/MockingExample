package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryImpl(List<Employee> employees) {

        this.employees = employees;

    }

    public EmployeeRepositoryImpl() {


    }


    @Override
    public List<Employee> findAll() {

        return employees;
    }

    @Override
    public Employee save(Employee e) {

        employees.removeIf(x -> x.getId().equals(e.getId()));
        employees.add(e);

        System.out.println(employees);

        return e;
    }

}
