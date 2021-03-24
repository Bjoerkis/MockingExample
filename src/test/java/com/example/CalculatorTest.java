package com.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calcTest = new Calculator();

    @Test
    void addTwoTest() {

        assertEquals(2, calcTest.add("1,1"));

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

        assertEquals(0, calcTest.add(""));

    }

    @Test
    void addDifferentDelimitersTest() {

        assertEquals(3, calcTest.add("//;\n1;1;1"));

    }

    @Test
    void negativesTest() {

        assertThrows(RuntimeException.class, () -> calcTest.add("-1, -1"));


    }

    @Test
    void over1000Test() {

        assertEquals(1, calcTest.add("1001,1"));

    }

    @Test
    void DelimiterAnyLengthTest() {

        assertEquals(3, calcTest.add("//[***]\n1**1**1"));
    }

    @Test
    void multipleDelimitersTest() {

        assertEquals(3, calcTest.add("//[*][%]\n1*1%1)"));

    }

    @Test
    void lengthMoreThanOneCharTest() {

        assertEquals(3, calcTest.add("//[***][//%%]\n1**1%%1)"));
    }

}