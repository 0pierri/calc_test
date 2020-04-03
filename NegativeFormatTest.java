package com.fdmgroup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NegativeFormatTest {

    private static Calculator calc = new Calculator();

    @Test
    public void test_neg2_sub_neg1_eq_neg1() {
        double result = calc.evaluate("-2--1");
        assertEquals(-1, result, 0);
    }

    @Test
    public void test_2_sub_neg1_eq_3() {
        double result = calc.evaluate("2--1");
        assertEquals(3, result, 0);
    }

    @Test
    public void test_neg2_add_neg1_eq_neg3() {
        double result = calc.evaluate("-2+-1");
        assertEquals(-3, result, 0);
    }

    @Test
    public void test_2_add_neg1_eq_1() {
        double result = calc.evaluate("2+-1");
        assertEquals(1, result, 0);
    }

    @Test
    public void test_subneg_addneg() {
        double result = calc.evaluate("1--2+-3");
        assertEquals(1-(-2)+-3, result, 0);
    }

}