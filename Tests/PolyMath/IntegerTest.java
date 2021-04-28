package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {

    Integer i1;
    Integer i2;
    Integer i3;

    @BeforeEach
    void setUp() {
        i1 = new Integer(15);
        i2 = new Integer(0);
        i3 = new Integer(-3);


    }

    @Test
    void add() {
        assertEquals("15", i1.add(i2).toString());
        assertEquals("12", i1.add(i3).toString());
        assertEquals("-3", i2.add(i3).toString());

    }

    @Test
    void mul() {
        assertEquals("225", i1.mul(i1).toString());
        assertEquals("0", i1.mul(i2).toString());
        assertEquals("9", i3.mul(i3).toString());
        assertEquals("-45", i1.mul(i3).toString());
    }

    @Test
    void power() {
        assertEquals("225", i1.power(2).toString());
        assertEquals("0", i2.power(15).toString());
        assertEquals("9", i3.power(2).toString());
        assertEquals("-27", i3.power(3).toString());


    }

    @Test
    void sign() {
        assertEquals(1, i1.sign());
        assertEquals(0, i2.sign());
        assertEquals(-1, i3.sign());
    }

    @Test
    void neg() {
        assertEquals("-15", i1.neg().toString());
        assertEquals("0", i2.neg().toString());
        assertEquals("3", i3.neg().toString());
    }

    @Test
    void testToString() {
        assertEquals("15", i1.toString());
    }
}