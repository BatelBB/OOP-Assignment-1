package PolyMath;
import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
    //**Added these classes just for the errors in Calculator, feel free to change anything**//

    private LinkedList<Monomial> polinom;

    //constructor
    public Polynomial(LinkedList<Monomial> polinom) {
        this.polinom = polinom;
    }


    public static Polynomial build(String s) {
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

    private static Scalar convertToRational(String s){
        String[] nums = s.split("/");
        return new Rational(java.lang.Integer.valueOf(nums[0]), java.lang.Integer.valueOf(nums[1]));
    }
    private static Scalar convertToInteger(String s){
        return new Integer(java.lang.Integer.valueOf(s));
    }

    public Polynomial add(Polynomial p1) throws Exception {
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

    private static Monomial next(Iterator<Monomial> iter){
        if(iter.hasNext())
            return iter.next();
        return null;
    }

    public Polynomial mul(Polynomial p5) {
        /*LinkedList<Monomial> newPol = new LinkedList<>();

        Iterator<Monomial> iter1 = polinom.iterator();
        Iterator<Monomial> iter2 = p5.polinom.iterator();

        Monomial m1 = next(iter1);
        Monomial m2 = next(iter2);*/
        return null;


    }

    public Scalar evaluate(Scalar r) throws Exception {
        Scalar eval = new Integer(0);
        for(Monomial mon: polinom){
            eval = eval.add(mon.evaluate(r));
        }

        return eval;
    }

    public Polynomial derivative() {
        return null;
    }

    public String toString(){
        String s = "";
        for(Monomial mon: polinom)
            s += mon.toString() + " ";


        if(s.charAt(0) == '+')
            return s.substring(2, s.length()-1);
        return s.substring(0, s.length()-1);
    }

}
