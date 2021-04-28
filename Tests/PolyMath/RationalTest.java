package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    Rational r1;
    Rational r2;
    Rational r3;
    Rational r4;

    @BeforeEach
    void setUp() {
        r1 = new Rational(-1,-1);
        r2 = new Rational(2, -4);
        r3 = new Rational(0, 8);

        try{
            r4 = new Rational(12, 0);
        }catch (Exception e){
            System.out.println("good r4");
        }
    }

    @Test
    void add() {
        try{
            Scalar r = r1.add(r2);
            assertEquals("+1/2", r.toString());
        }catch (Exception e){
            System.out.println("not good add 1: " + e.getMessage());
        }

        try{
            assertEquals("+1", r1.add(r3).toString());
        }catch (Exception e){
            System.out.println("not good add 2: " + e.getMessage());
        }

        try{
            assertEquals("-1/2", r2.add(r3).toString());
        }catch (Exception e){
            System.out.println("not good add 3: " + e.getMessage());
        }

        try{
            assertEquals("+2", r1.add(r1).toString());
        }catch (Exception e){
            System.out.println("not good add 4: " + e.getMessage());
        }
    }

    @Test
    void mul() {
        try{
            Scalar r = r1.mul(r2);
            assertEquals("-1/2", r.toString());
        }catch (Exception e){
            System.out.println("not good mul 1: " + e.getMessage());
        }

        try{
            assertEquals("0", r1.mul(r3).toString());
        }catch (Exception e){
            System.out.println("not good mul 2: " + e.getMessage());
        }

        try{
            assertEquals("0", r2.mul(r3).toString());
        }catch (Exception e){
            System.out.println("not good mul 3: " + e.getMessage());
        }

        try{
            assertEquals("+1", r1.mul(r1).toString());
        }catch (Exception e){
            System.out.println("not good mul 4: " + e.getMessage());
        }
        try{
            assertEquals("+1/4", r2.mul(r2.neg()).toString());
        }catch (Exception e){
            System.out.println("not good mul 5: " + e.getMessage());
        }

    }

    @Test
    void power() {
        try{
            assertEquals("+1", r1.power(13).toString());
        }catch (Exception e){
            System.out.println("not good power 1: " + e.getMessage());
        }

        try{
            assertEquals("+1", r1.power(0).toString());
        }catch (Exception e){
            System.out.println("not good power 2: " + e.getMessage());
        }

        try{
            assertEquals("+1", r1.power(-2).toString());
        }catch (Exception e){
            System.out.println("not good power 3: " + e.getMessage());
        }

        try{
            assertEquals("+1/4", r2.power(2).toString());
        }catch (Exception e){
            System.out.println("not good power 4: " + e.getMessage());
        }
        try{
            Scalar rr = r2.power(-1);
            assertEquals("-2", r2.power(-1).toString());
        }catch (Exception e) {
            System.out.println("not good power 5: " + e.getMessage());
        }
        try{
            assertEquals("0", r3.power(-1).toString());
        }catch (Exception e) {
            System.out.println("not good power 6: " + e.getMessage());
        }
    }

    @Test
    void sign() {
        assertEquals(1, r1.sign());
        assertEquals(-1, r1.neg().sign());
        assertEquals(-1, r2.sign());
        assertEquals(-1, r2.neg().neg().sign());
        assertEquals(0, r3.sign());
    }


    @Test
    void testToString() {
        assertEquals("+1", r1.toString());
        assertEquals("-1/2", r2.toString());
        assertEquals("0", r3.toString());
    }
}