package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    @Test
    void addTest() {
        int actual = EmployeeManager.add("1","2");
        assertEquals(3,actual);


    }
    @Test
    void addEmptyTest() {

        int actual = EmployeeManager.add("","");
        assertEquals(0,actual);


    }
    @Test
    void ifNumOneEmptyTest() {

        int actual = EmployeeManager.add("","1");
        assertEquals(1,actual);

    }
    @Test
    void ifNumTwoEmptyTest() {
        int actual = EmployeeManager.add("1","0");
        assertEquals(1,actual);

    }
    @Test
    void manyNumbersTest() {
        int actual = EmployeeManager.add("1","2","3","4");
        assertEquals(10,actual);
    }
}