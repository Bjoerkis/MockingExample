package com.example;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeManagerIT {

    EmployeeRepository er = new EmployeeRepositoryImpl((List.of(
            new Employee("1", 500),
            new Employee("2", 500))));
    BankService bsMockito = Mockito.mock(BankService.class);
    EmployeeManager employeeManager = new EmployeeManager(er, bsMockito);

    @Test
    void isPaidTest() {

        employeeManager.payEmployees();
        assertEquals(2, employeeManager.payEmployees());

    }

    @Test
    void runTimeExceptionTest() {

        Mockito.doThrow(new RuntimeException()).when(bsMockito).pay("1", 500);
        assertEquals(1, employeeManager.payEmployees());


    }

}