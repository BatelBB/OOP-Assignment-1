package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    Monomial m0;
    Monomial m1;
    Monomial m2;
    Monomial m3;
    Monomial m4;


    @BeforeEach
    void setUp() {
        m0 = new Monomial(0, new Integer(0));
        m1 = new Monomial(0, new Rational(0,-6));
        m2 = new Monomial( 1, new Integer(-2));
        m3 = new Monomial(1, new Rational(4, -6));
        m4 = new Monomial(2, new Rational(3, 6));
    }

    @Test
    void add() {
    }

    @Test
    void mult() {
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
        assertEquals("", m0.toString());
        assertEquals("", m1.toString());
        assertEquals("-2x", m2.toString());
        assertEquals("-2/3x", m3.toString());
        assertEquals("+1/2x^2", m4.toString());

    }
}