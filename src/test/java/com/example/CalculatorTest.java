package com.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calcTest = new Calculator();

    @Test
    void addTwoTest(){

        assertEquals(2,calcTest.add("1,1"));

    }
    @Test
    void addMoreDelimitersTest() {

        assertEquals(2, calcTest.add("1\n1"));

    }


    @Test
    void addTest() {

        assertEquals(8, calcTest.add("1\n1;1,1/1^1*1=1"));

    }

    @Test
    void addEmptyTest() {

        assertEquals(0 ,calcTest.add(""));

    }

}