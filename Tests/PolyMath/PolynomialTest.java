package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    Polynomial p1;
    Polynomial p2;
    Polynomial p3;
    Polynomial p4;
    Polynomial p5;



    @BeforeEach
    void setUp() {
        p1 = Polynomial.build("");
        p2 = Polynomial.build("1 2");
        p3 = Polynomial.build("1/2 3 5");
        p4 = Polynomial.build("0 2/-4 2/1");

    }

    @Test
    void add() {
        assertEquals("1+2x", p1.add(p2).toString());
        assertEquals("0", p1.add(p1).toString());
        assertEquals("1+2x", p2.add(p1).toString());
        assertEquals("1/2+5/2x+7x^2", p3.add(p4).toString());
        assertEquals("1+6x+10x^2", p3.add(p3).toString());
    }

    @Test
    void mul() {
        assertEquals("0", p1.mul(p2).toString());
        assertEquals("0", p1.mul(p3).toString());
        assertEquals("1/2+4x+11x^2+10x^3", p2.mul(p3).toString());
        assertEquals("-1/2x+x^2+4x^3", p2.mul(p4).toString());
        assertEquals("-1/2x+x^2+4x^3", p4.mul(p2).toString());
        assertEquals("-1/4x-1/2x^2+7/2x^3+10x^4", p3.mul(p4).toString());

    }

    @Test
    void evaluate() {
    }

    @Test
    void derivative() {
    }

    @Test
    void testToString() {

        assertEquals("0", p1.toString());
        assertEquals("1+2x", p2.toString());
        assertEquals("1/2+3x+5x^2", p3.toString());
        assertEquals("-1/2x+2x^2", p4.toString());
    }
}