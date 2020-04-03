package com.fdmgroup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExpTest {

    private static Calculator calc = new Calculator();

    //region Zero exponent
    @Test
    public void test_2_exp_0() {
        double result = calc.evaluate("2^0");
        assertEquals(1, result, 0);
    }

    @Test
    public void test_2_exp_neg0() {
        double result = calc.evaluate("2^-0");
        assertEquals(1, result, 0);
    }

    @Test
    public void test_0_exp_0() {
        double result = calc.evaluate("0^0");
        assertEquals(Math.pow(0, 0), result, 0);
    }
    //endregion

    //region Positive integer exponent
    @Test
    public void test_2_exp_1_eq_1() {
        double result = calc.evaluate("2^1");
        assertEquals(2, result, 0);
    }

    @Test
    public void test_2_exp_2_eq_4() {
        double result = calc.evaluate("2^2");
        assertEquals(4, result, 0);
    }    

    @Test
    public void test_1_exp_100_eq_1() {
        double result = calc.evaluate("1^100");
        assertEquals(1, result, 0);
    }
    //endregion

    //region Negative integer exponent
    @Test
    public void test_2_exp_neg1() {
        double result = calc.evaluate("2^-1");
        assertEquals(Math.pow(2, -1), result, 0);
    }

    @Test
    public void test_2_exp_neg2() {
        double result = calc.evaluate("2^-2");
        assertEquals(Math.pow(2, -2), result, 0);
    }

    @Test
    public void test_1_exp_neg100() {
        double result = calc.evaluate("1^-100");
        assertEquals(Math.pow(1, -100), result, 0);
    }
    //endregion

    //region Bracketed integer exponent
    @Test
    public void test_1_exp_bracketed_int_add() {
        double result = calc.evaluate("1^(2+3)");
        assertEquals(Math.pow(1, 2+3), result, 0);
    }

    @Test
    public void test_2_exp_bracketed_int_add() {
        double result = calc.evaluate("2^(3+4)");
        assertEquals(Math.pow(2, 3+4), result, 0);
    }

    @Test
    public void test_2_exp_bracketed_int_sub() {
        double result = calc.evaluate("2^(3-4)");
        assertEquals(Math.pow(2, 3-4), result, 0);
    }

    @Test
    public void test_2_exp_bracketed_int_mul() {
        double result = calc.evaluate("2^(3*4)");
        assertEquals(Math.pow(2, 3*4), result, 0);
    }

    @Test
    public void test_2_exp_bracketed_int_div() {
        double result = calc.evaluate("2^(4/2)");
        assertEquals(Math.pow(2, 4/2), result, 0);
    }

    @Test
    public void test_2_exp_nested_bracketed_int() {
        double result = calc.evaluate("2^(4*(2+3))");
        assertEquals(Math.pow(2, 4*(2+3)), result, 0);
    }

    @Test
    public void test_bracketed_int_exp_bracketed_int() {
        double result = calc.evaluate("(6/3)^(4*(2+3))");
        assertEquals(Math.pow(6/3, 4*(2+3)), result, 0);
    }
    //endregion

    //region Decimal exponent
    @Test
    public void test_1_exp_decimal() {
        double result = calc.evaluate("1^0.5");
        assertEquals(Math.pow(1, 0.5), result, 0);
    }

    @Test
    public void test_2_exp_decimal() {
        double result = calc.evaluate("2^0.1");
        assertEquals(Math.pow(2, 0.1), result, 0);
    }
    //endregion

    //region Bracketed float exponent
    @Test
    public void test_2_exp_bracketed_float() {
        double result = calc.evaluate("2^(3/4)");
        assertEquals(Math.pow(2, 3.0/4), result, 0);
    }

    @Test
    public void test_2_exp_nested_bracket_float() {
        double result = calc.evaluate("2^((3+4)/5)");
        assertEquals(Math.pow(2, (double)(3+4)/5), result, 0);
    }

    @Test
    public void test_bracketed_int_exp_bracketed_float() {
        double result = calc.evaluate("(2-3*4)^(1/(2+4)*3)");
        assertEquals(Math.pow(2-3*4, 1.0/(2+4)*3), result, 0);
    }

    @Test
    public void test_bracketed_float_exp_bracketed_float() {
        double result = calc.evaluate("(2-3/4)^(1/(2+4)/3)");
        assertEquals(Math.pow(2-3.0/4, 1.0/(2+4)/3), result, 0);
    }
    //endregion

    //region Nested exponent
    @Test
    public void test_int_exp_exp() {
        double result = calc.evaluate("4^3^2");
        assertEquals(Math.pow(4, Math.pow(3, 2)), result, 0);
    }

    @Test
    public void test_int_exp_bracketed_exp() {
        double result = calc.evaluate("4^(3^2)");
        assertEquals(Math.pow(4, Math.pow(3, 2)), result, 0);
    }
}