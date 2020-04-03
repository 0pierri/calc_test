package com.fdmgroup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BracketTest {

    private static Calculator calc = new Calculator();

    @Test
    public void test_surrounding_brackets_do_nothing() {
        double result = calc.evaluate("(((2+3/4-5*6)))");
        assertEquals(2+3.0/4-5*6, result, 0);
    }

    @Test
    public void test_bracketed_neg_noop() {
        double result = calc.evaluate("(-1)");
        assertEquals(-1, result, 0);
    }

    @Test
    public void test_add_then_mul() {
        double result = calc.evaluate("(2+3)*4");
        assertEquals((2+3)*4, result, 0);
    }

    @Test
    public void test_div_by_sub() {
        double result = calc.evaluate("2/(3-4)");
        assertEquals(2/(3-4), result, 0);
    }

    @Test
    public void test_sub_then_div_by_sub() {
        double result = calc.evaluate("(2-3)/(4-5)");
        assertEquals((2-3)/(4-5), result, 0);
    }

    @Test
    public void test_sub_inside_add_then_mul() {
        double result = calc.evaluate("((2+3)-4)*5");
        assertEquals(((2+3)-4)*5, result, 0);
    }

    @Test
    public void test_div_by_add_inside_sub() {
        double result = calc.evaluate("2/(3-(4+5))");
        assertEquals(2.0/(3-(4+5)), result, 0);
    }

    @Test
    public void test_neg_bracket() {
        double result = calc.evaluate("-(2+3)");
        assertEquals(-5, result, 0);
    }

    @Test
    public void test_inner_neg_bracket() {
        double result = calc.evaluate("2*(-(3-4))");
        assertEquals(2*(-(3-4)), result, 0);
    }

    @Test
    public void test_div_bracketed_neg() {
        double result = calc.evaluate("1/(-3)");
        assertEquals(1.0/(-3), result, 0);
    }

    @Test
    public void test_multi_nested_neg() {
        double result = calc.evaluate("-(-(-(-1)))");
        assertEquals(1, result, 0);
    }

    @Test
    public void test_inf_div_inf_eq_nan() {
        double result = calc.evaluate("(1/0)/(1/0)");
        assertEquals(Double.NaN, result, 0);
    }
}