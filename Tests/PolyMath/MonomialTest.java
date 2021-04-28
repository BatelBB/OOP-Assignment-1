package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    Monomial m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10;

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
    }

    @Test
    void add() {
        assertEquals("0", m0.add(m1).toString()); //0^0+(0/6)^0
        assertEquals("-4x", m2.add(m2).toString()); //(-2^1)+(-2^1)
        assertEquals("-8/3x", m3.add(m2).toString()); //(4/(-6))^1 + (-2^1) = -8/3
        assertNull(m4.add(m3)); // (3/6)^2 + (4/(-6))^1 ==> null - different exponent
        assertNull(m5.add(m4)); // 3^3 + (3/6)^2 ==> null - different exponent
        assertEquals("13/4x^3", m6.add(m5).toString()); // (2/8)x^3 + 3x^3 = 13/4x

    }

    @Test
    void mult() {
        assertNull(m0.mult(m1)); // 0^0 * (0/6)^0 ==> null - different coefficient
        assertEquals("1/16x^5", m7.mult(m6).toString()); // (1/4)^2 * (2/8)^3
    }

    @Test
    void evaluate() {
    }

    @Test
    void derivative() {
    }

    @Test
    void sign() {
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