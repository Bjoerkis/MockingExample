package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeManagerTest {

    BankService bs = new BankServiceTest();
    EmployeeRepository er = new EmployeeRepositoryTest();
    EmployeeManager employeemanager = new EmployeeManager(er, bs);


    @Test
    void isPaidTest() {

        employeemanager.payEmployees();
        assertEquals(1, employeemanager.payEmployees());

    }

    @Test
    void isPaidMockitoTest() {

        List<Employee> employees = new ArrayList<>();
        Employee steve = new Employee("1", 500);
        employees.add(steve);

        BankService bsMockito = Mockito.mock(BankService.class);
        EmployeeRepository erMockito = Mockito.mock(EmployeeRepository.class);
        Mockito.when(erMockito.findAll()).thenReturn(employees);
        EmployeeManager emMockito = new EmployeeManager(erMockito, bsMockito);

        assertEquals(1, emMockito.payEmployees());

    }
    @Test
    void exceptionMockitoTest() {

        List<Employee> employees = new ArrayList<>();
        Employee steve = new Employee("1", 500);
        employees.add(steve);

        BankService bsMockito = Mockito.mock(BankService.class);
        EmployeeRepository erMockito = Mockito.mock(EmployeeRepository.class);
        Mockito.when(erMockito.findAll()).thenReturn(employees);
        EmployeeManager emMockito = new EmployeeManager(erMockito, bsMockito);


        Mockito.doThrow(new RuntimeException()).when(bsMockito).pay("1",500);
        assertEquals(0,emMockito.payEmployees());

    }

}