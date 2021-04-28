package PolyMath;
import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {

    private LinkedList<Monomial> polinom;

    //constructor
    private Polynomial(LinkedList<Monomial> polinom) {
        this.polinom = polinom;
    }


    public static Polynomial build(String s) {
        if(s == null)
            throw new IllegalArgumentException("String can't be null");

        LinkedList<Monomial> newPol = new LinkedList<>();

        String[] pol = s.split(" ", -1);
        for(int i = 0; i < pol.length ;i++){
            if(!pol[i].equals("")) {
                if (pol[i].contains("/"))
                    newPol.add(new Monomial(i, convertToRational(pol[i])));
                else
                    newPol.add(new Monomial(i, convertToInteger(pol[i])));
            }
        }

        return new Polynomial(newPol);
    }

    /**
     * Converts a string to rational number
     * @param s the string that needs to be converted to the number
     * @return a scalar that is the new rational number
     */
    private static Scalar convertToRational(String s){
        String[] nums = s.split("/");
        return new Rational(java.lang.Integer.valueOf(nums[0]), java.lang.Integer.valueOf(nums[1]));
    }

    /**
     * Converts a string to integer number
     * @param s the string that needs to be converted to the number
     * @return a scalar that is the new Integer number
     */
    private static Scalar convertToInteger(String s){
        return new Integer(java.lang.Integer.valueOf(s));
    }

    public Polynomial add(Polynomial p1)  {
        LinkedList<Monomial> newPol = new LinkedList<>();

        Iterator<Monomial> iter1 = polinom.iterator();
        Iterator<Monomial> iter2 = p1.polinom.iterator();

        Monomial m1 = next(iter1);
        Monomial m2 = next(iter2);

        while (m1 != null && m2 != null) {
            if (m1.getExponent() == m2.getExponent()) {
                newPol.add((m1.add(m2)));
                m1 = next(iter1);
                m2 = next(iter2);
            }
            else if (m1.getExponent() < m2.getExponent()){
                newPol.add(m1);
                m1 = next(iter1);
            }
            else {
                newPol.add(m2);
                m2 = next(iter2);
            }
        }

        while (m1 != null){
            newPol.add(m1);
            m1 = next(iter1);
        }

        while (m2 != null){
            newPol.add(m2);
            m2 = next(iter2);
        }

        return new Polynomial(newPol);
    }

    /**
     * An iterator
     * @param iter the iterator
     * @return a Monomial that is next in the Iterator
     */
    private static Monomial next(Iterator<Monomial> iter){
        if(iter.hasNext())
            return iter.next();
        return null;
    }

    public Polynomial mul(Polynomial p5) {
        Polynomial p = Polynomial.build("");
        LinkedList<Monomial> list = new LinkedList<>();

        Iterator<Monomial> iter1 = polinom.iterator();
        Iterator<Monomial> iter2 = p5.polinom.iterator();

        Monomial m1 = next(iter1);
        Monomial m2 = next(iter2);


        while (m1 != null) {
            while (m2 != null) {
                list.add(m1.mult(m2));
                m2 = next(iter2);
            }

            p = p.add(new Polynomial(list));
            list = new LinkedList<>();
            iter2 = p5.polinom.iterator();
            m1 = next(iter1);
            m2 = next(iter2);
        }

        return p;


    }

    public Scalar evaluate(Scalar r) {
        Scalar eval = new Integer(0);
        for(Monomial mon: polinom){
            eval = eval.add(mon.evaluate(r));
        }

        return eval;
    }

    public Polynomial derivative() {
        LinkedList<Monomial> p = new LinkedList<>();

        for(Monomial m : polinom){
            p.add(m.derivative());
        }

        return new Polynomial(p);
    }

    public String toString(){
        String s = "";

        for(Monomial m: polinom){
            String curM = m.toString();
            if(!curM.equals("0")) {
                if (curM.charAt(0) != '-')
                    s += "+";
                s += m.toString();
            }
        }

        if (s.equals(""))
            s = "0";
        else if(s.charAt(0) == '+')
            s = s.substring(1, s.length());

        return s;
    }

}
