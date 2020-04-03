package com.fdmgroup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for input strings containing multiple operators.
 */
public class MultiOperatorTest {
    private static Calculator calc = new Calculator();

    //region Add/Sub
    @Test
    public void test_add_add() {
        double result = calc.evaluate("1+2+3");
        assertEquals(1+2+3, result, 0);
    }

    @Test
    public void test_add_sub() {
        double result = calc.evaluate("1+2-3");
        assertEquals(1+2-3, result, 0);
    }

    @Test
    public void test_sub_add() {
        double result = calc.evaluate("1-2+3");
        assertEquals(1-2+3, result, 0);
    }

    @Test
    public void test_sub_sub() {
        double result = calc.evaluate("1-2-3");
        assertEquals(1-2-3, result, 0);
    }

    @Test
    public void test_subneg_addneg() {
        double result = calc.evaluate("1--2+-3");
        assertEquals(1-(-2)+-3, result, 0);
    }

    @Test
    public void test_2_add_neg1_eq_1() {
        double result = calc.evaluate("2+-1");
        assertEquals(1, result, 0);
    }

    @Test
    public void test_neg2_add_1_eq_neg1() {
        double result = calc.evaluate("-2+1");
        assertEquals(-1, result, 0);
    }

    @Test
    public void test_neg2_add_neg1_eq_neg3() {
        double result = calc.evaluate("-2+-1");
        assertEquals(-3, result, 0);
    }

    @Test
    public void test_2_sub_neg1_eq_3() {
        double result = calc.evaluate("2--1");
        assertEquals(3, result, 0);
    }

    @Test
    public void test_neg2_sub_1_eq_neg3() {
        double result = calc.evaluate("-2-1");
        assertEquals(-3, result, 0);
    }

    @Test
    public void test_neg2_sub_neg1_eq_neg1() {
        double result = calc.evaluate("-2--1");
        assertEquals(-1, result, 0);
    }
    //endregion

    //region Div/Mul
    @Test
    public void test_mul_mul() {
        double result = calc.evaluate("2*3*4");
        assertEquals(2*3*4, result, 0);
    }

    @Test
    public void test_div_mul() {
        double result = calc.evaluate("12/4*2");
        assertEquals(12.0/4*2, result, 0);
    }

    @Test
    public void test_mul_div() {
        double result = calc.evaluate("3*5/2");
        assertEquals(3.0*5/2, result, 0);
    }

    @Test
    public void test_div_div() {
        double result = calc.evaluate("12/4/2");
        assertEquals(12.0/4/2, result, 0);
    }

    @Test
    public void test_2_mul_neg1_eq_neg2() {
        double result = calc.evaluate("2*-1");
        assertEquals(-2, result, 0);
    }

    @Test
    public void test_neg2_mul_1_eq_neg2() {
        double result = calc.evaluate("-2*1");
        assertEquals(-2, result, 0);
    }

    @Test
    public void test_neg2_mul_neg1_eq_2() {
        double result = calc.evaluate("-2*-1");
        assertEquals(2, result, 0);
    }

    @Test
    public void test_2_div_neg1_eq_neg2() {
        double result = calc.evaluate("2/-1");
        assertEquals(-2, result, 0);
    }

    @Test
    public void test_neg2_div_1_eq_neg2() {
        double result = calc.evaluate("-2/1");
        assertEquals(-2, result, 0);
    }

    @Test
    public void test_neg2_div_neg1_eq_2() {
        double result = calc.evaluate("-2/-1");
        assertEquals(2, result, 0);
    }
    //endregion

    //region Combination
    @Test
    public void test_mul_add() {
        double result = calc.evaluate("2*3+4");
        assertEquals(2*3+4, result, 0);
    }

    @Test
    public void test_sub_mul() {
        double result = calc.evaluate("2+3*4");
        assertEquals(2+3*4, result, 0);
    }

    @Test
    public void test_div_sub() {
        double result = calc.evaluate("2/3-4");
        assertEquals(2.0/3-4, result, 0);
    }

    @Test
    public void test_add_div() {
        double result = calc.evaluate("2+3/4");
        assertEquals(2+3.0/4, result, 0);
    }
    //endregion

    //region Mix it up
    @Test
    public void test_div_add_mul() {
        double result = calc.evaluate("2/3+4*5");
        assertEquals(2.0/3+4*5, result, 0);
    }

    @Test
    public void test_sub_div_mul_add_div() {
        double result = calc.evaluate("2-3/4*5+6/7");
        assertEquals(2-3.0/4*5+6.0/7, result, 0);
    }

    @Test
    public void test_sub_sub_mul_add_add() {
        double result = calc.evaluate("2-3-4*5+6+7");
        assertEquals(2-3-4*5+6+7, result, 0);
    }
    //endregion

    //region More inf
    @Test
    public void test_inf_add_2_eq_inf() {
        double result = calc.evaluate("1/0+2");
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }

    @Test
    public void test_inf_sub_2_eq_inf() {
        double result = calc.evaluate("1/0-2");
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }

    @Test
    public void test_inf_div_2_eq_inf() {
        double result = calc.evaluate("1/0/2");
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }

    @Test
    public void test_inf_mul_2_eq_inf() {
        double result = calc.evaluate("1/0*2");
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }

    @Test
    public void test_inf_add_inf_eq_nan() {
        double result = calc.evaluate("1/0+1/0");
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }
    
    @Test
    public void test_neginf_sub_inf_eq_nan() {
        double result = calc.evaluate("-1/0-1/0");
        assertEquals(Double.NEGATIVE_INFINITY, result, 0);
    }
    //endregion

    //region More NaN
    @Test
    public void test_inf_add_neginf_eq_nan() {
        double result = calc.evaluate("1/0+-1/0");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_neginf_add_inf_eq_nan() {
        double result = calc.evaluate("-1/0+1/0");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_inf_mul_0_eq_nan() {
        double result = calc.evaluate("1/0*0");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_0_mul_neginf_eq_nan() {
        double result = calc.evaluate("0*-1/0");
        assertEquals(Double.NaN, result, 0);
    }

    @Test
    public void test_nan_add_nan_eq_nan() {
        double result = calc.evaluate("0/0+0/0");
        assertEquals(Double.NaN, result, 0);
    }
    //endregion

}