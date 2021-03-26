package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryIT {

    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    Employee steve = new Employee("1", 500);


    @Test
    void findAllFunctionalityTest() {


        assertTrue(employeeRepository.findAll().isEmpty());

    }

    @Test
    void saveFunctionalityTest() {

        employeeRepository.save(steve);

        assertTrue(employeeRepository.findAll().contains(steve));

    }
    @Test
    void saveDuplicatesIsRemovedTest() {

        employeeRepository.save(steve);
        employeeRepository.save(steve);


        assertEquals( 1,employeeRepository.findAll().size());

    }

}