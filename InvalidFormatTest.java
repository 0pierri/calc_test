package com.fdmgroup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvalidFormatTest {

    private static Calculator calc = new Calculator();

    @Test
    public void test_spaces_ignored() {
        double result = calc.evaluate(" 2* (   - ( 3   -4 ) )   ");
        assertEquals(2*(-(3-4)), result, 0);
    }

    @Test
    public void test_invalid_char_fails() {
        double result = calc.evaluate("2 + a");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_div_mul_fails() {
        double result = calc.evaluate("2/*2");
        assertEquals(Double.NaN, result, 0);
    }    

    @Test
    public void test_triple_neg_fails() {
        double result = calc.evaluate("1---1");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_neg_plus_fails() {
        double result = calc.evaluate("1-+1");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_neg_div_fails() {
        double result = calc.evaluate("1-/1");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_lone_dot_fails() {
        double result = calc.evaluate(".");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_bracketed_dot_fails() {
        double result = calc.evaluate("(.)");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_open_bracket_dot_add_1_fails() {
        double result = calc.evaluate("(.+1)");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_add_before_close_bracket_fails() {
        double result = calc.evaluate("(1+)");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_add_dot_before_close_bracket_fails() {
        double result = calc.evaluate("(1+.)");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_dot_after_bracket_fails() {
        double result = calc.evaluate("(1+2).3");
        assertEquals(Double.NaN, result, 0);
    }

}