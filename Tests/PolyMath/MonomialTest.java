package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    Monomial m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12;

    @BeforeEach
    void setUp() {
        m0 = new Monomial(0, new Integer(0));
        m1 = new Monomial(0, new Rational(0,-6));
        m2 = new Monomial( 1, new Integer(-2));
        m3 = new Monomial(1, new Rational(4, -6));
        m4 = new Monomial(2, new Rational(3, 6));
        m5 = new Monomial(3, new Integer(3));
        m6 = new Monomial(3, new Rational(2, 8));
        m7 = new Monomial(2, new Rational(1, 4));
        m8 = new Monomial(2/9, new Integer(9));
        m9 = new Monomial(5,new Integer(10));
        m10 = new Monomial(0, new Integer(5));
        m11 = new Monomial(3, new Integer(0));

    }

    @Test
    void add() {
        assertEquals("0", m0.add(m1).toString()); //0x^0+(0/6)x^0
        assertEquals("-4x", m2.add(m2).toString()); //(-2^1)+(-2^1)
        assertEquals("-8/3x", m3.add(m2).toString()); //(4/(-6))^1 + (-2^1) = -8/3
        assertNull(m4.add(m3)); // (3/6)^2 + (4/(-6))^1 ==> null - different exponent
        assertNull(m5.add(m4)); // 3^3 + (3/6)^2 ==> null - different exponent
        assertEquals("13/4x^3", m6.add(m5).toString()); // (2/8)x^3 + 3x^3 = 13/4x
        assertEquals("10x^5", m1.add(m9).toString()); //0x^0 + 10x^5 = 10x^5
        assertEquals("1/4x^3",m11.add(m6).toString()); // 0x^3 + 2/8x^3 = 1/4x^3
    }

    @Test
    void mult() {
        try {
            assertEquals("0", m0.mult(m1).toString()); // 0x^0 * (0/6)x^0 ==> denominator cannot be 0
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals("1/16x^5", m7.mult(m6).toString()); // (1/4)x^2 * (2/8)x^3 = 1/16x^5
        assertEquals("4/3x^2", m2.mult(m3).toString());// -2x^1 * (4/-6)x^1 = 4/3x^2
        assertEquals("3/2x^5", m4.mult(m5).toString()); // (3/6)x^2 * 3x^3 = 3/2x^5
        assertEquals("-1/3x^3", m4.mult(m3).toString()); // (3/6)x^2 * (4/-6)x^1 = -1/3x^3
        assertEquals("50x^5",m10.mult(m9).toString()); // 5x^0 * 10x^5 = 50x^5
        assertEquals("90x^5",m8.mult(m9).toString()); //9x^(2/9) * 10x^5 = 90x^(47/9)
    }

    @Test
    void evaluate() {
        assertEquals("24",m5.evaluate(new Integer(2)).toString()); //3*2^3 = 24
        assertEquals("0", m0.evaluate(new Integer(2)).toString()); //0*2^0 = 0
        assertEquals("0",m1.evaluate(new Integer(9)).toString()); //0/-6*9^0 = 0
        assertEquals("0",m11.evaluate(new Integer(0)).toString()); //0 * 0^3 = 0
        assertEquals("5",m10.evaluate(new Integer(0)).toString()); //5 * 0^0 = 5
        assertEquals("-4",m2.evaluate(new Integer(2)).toString()); //-2 * 2^1 = -4
        assertEquals("9/4",m7.evaluate(new Integer(3)).toString());//1/4 * 3^2 = 9/4
        assertEquals("128/27",m6.evaluate(new Rational(8,3)).toString()); //1/4 * 8/3^3 = 128/27
        assertEquals("10/59049",m9.evaluate(new Rational(1,9)).toString());//10*1/9^5 = 10/59049
        assertEquals("-2/21",m3.evaluate(new Rational(1,7)).toString()); //4/-6 * 1/7^1 =-2/21
    }

    @Test
    void derivative() {
    }

    @Test
    void sign() {
        assertEquals(0, m0.sign());
        assertEquals(-1, m2.sign());
        assertEquals(-1, m3.sign());
        assertEquals(1, m4.sign());

    }

    @Test
    void testToString() {
        assertEquals("0", m0.toString());
        assertEquals("0", m1.toString());
        assertEquals("-2x", m2.toString());
        assertEquals("-2/3x", m3.toString());
        assertEquals("1/2x^2", m4.toString());

    }
}