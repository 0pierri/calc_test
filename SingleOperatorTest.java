package com.fdmgroup;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for input strings containing a single or no operator.
 */
public class SingleOperatorTest {

    private static Calculator calc = new Calculator();
    
    //region No-op
    @Test
    public void test_noop_0_eq_0() {
        double result = calc.evaluate("0");
        assertEquals(0, result, 0);
    }

    @Test
    public void test_noop_1_eq_1() {
        double result = calc.evaluate("1");
        assertEquals(1, result, 0);
    }

    @Test
    public void test_noop_neg2_eq_neg2() {
        double result = calc.evaluate("-2");
        assertEquals(-2, result, 0);
    }

    @Test
    public void test_noop_1_5_eq_1_5() {
        double result = calc.evaluate("1.5");
        assertEquals(1.5, result, 0);
    }

    @Test
    public void test_noop_neg1_5_eq_neg1_5() {
        double result = calc.evaluate("-1.5");
        assertEquals(-1.5, result, 0);
    }

    @Test
    public void test_noop_dot1_eq_dot1() {
        double result = calc.evaluate(".1");
        assertEquals(.1, result, 0);
    }

    @Test
    public void test_noop_1dot_eq_1() {
        double result = calc.evaluate("1.");
        assertEquals(1, result, 0);
    }
    //endregion

    //region Basics
    @Test
    public void test_2_add_1_eq_3() {
        double result = calc.evaluate("2+1");
        assertEquals(3, result, 0);    
    }

    @Test
    public void test_2_sub_1_eq_1() {
        double result = calc.evaluate("2-1");
        assertEquals(1, result, 0);
    }
    
    @Test
    public void test_2_mul_1_eq_2() {
        double result = calc.evaluate("2*1");
        assertEquals(2, result, 0);
    }
    @Test
    public void test_2_div_1_eq_2() {
        double result = calc.evaluate("2/1");
        assertEquals(2, result, 0);
    }

    @Test
    public void test_negative_noop() {
        double result = calc.evaluate("-1");
        assertEquals(-1, result, 0);
    }
    //endregion
    
    //region Float
    @Test
    public void test_float_add() {
        double result = calc.evaluate("0.5+0.1");
        assertEquals(0.5+0.1, result, 0);
    }

    @Test
    public void test_float_sub() {
        double result = calc.evaluate("0.5-0.1");
        assertEquals(0.5-0.1, result, 0);
    }

    @Test
    public void test_float_mul() {
        double result = calc.evaluate("0.5*0.1");
        assertEquals(0.5*0.1, result, 0);
    }

    @Test
    public void test_float_div() {
        double result = calc.evaluate("0.5/0.1");
        assertEquals(0.5/0.1, result, 0);
    }
    //endregion

    //region Infinity
    @Test
    public void test_2_div_0_eq_inf() {
        double result = calc.evaluate("2/0");
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }

    @Test
    public void test_2_div_neg0_eq_neginf() {
        double result = calc.evaluate("2/-0");
        assertEquals(Double.NEGATIVE_INFINITY, result, 0);
    }

    @Test
    public void test_neg2_div_0_eq_neginf() {
        double result = calc.evaluate("-2/0");
        assertEquals(Double.NEGATIVE_INFINITY, result, 0);
    }

    @Test
    public void test_neg2_div_neg0_eq_inf() {
        double result = calc.evaluate("-2/-0");
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }
    //endregion

    //region NaN
    @Test
    public void test_0_div_0_eq_nan() {
        double result = calc.evaluate("0/0");
        assertEquals(Double.NaN, result, 0);
    }
    //endregion
}
