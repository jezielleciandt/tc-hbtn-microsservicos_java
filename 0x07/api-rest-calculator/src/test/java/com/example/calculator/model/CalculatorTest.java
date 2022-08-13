package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Autowired
    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }
    @Test
    void sumTest() {
        assertEquals(5.0, calculator.sum(2.0, 3.0));
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 6.0));
    }

    @Test
    void subTest() {
        assertEquals(1.0, calculator.sub(3.0, 2.0));
    }

    @Test
    void divideTest() {
        assertEquals(6.0, calculator.divide(12.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(6.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(6, calculator.factorial(3));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(101, calculator.integerToBinary(5));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("AA".toLowerCase(), calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        assertEquals(15, calculator.calculeDayBetweenDate(LocalDate.of(2022, 9, 15), LocalDate.of(2020, 9, 30)));
    }
}
