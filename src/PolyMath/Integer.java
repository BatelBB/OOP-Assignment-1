package PolyMath;

public class Integer implements Scalar {

    private int number;

    public Integer(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Scalar add(Scalar s) {
        /*if(s instanceof Integer){
            int num = java.lang.Integer.valueOf(s.toString());
            return addInteger(new Integer(num));
        }
        else {
            return s.addRational(new Rational(number, 1));
        }*/

        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        if(s instanceof Integer){
            int num = java.lang.Integer.valueOf(s.toString());
            return mulInteger(new Integer(num));
        }
        else {
            return s.mulRational(new Rational(number, 1));
        }
    }

    @Override
    public Scalar addRational(Rational s) {
        return null;
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(number + s.number);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return s.addRational(new Rational(number, 1));
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(number * s.number);
    }

    @Override
    public Scalar power(int exponent) {
        return new Integer((int)Math.pow((double)number, (double)exponent));
    }

    @Override
    public int sign() {
        if(number == 0)
            return 0;
        else if(number > 0)
            return 1;
        else
            return -1;
    }

    @Override
    public Scalar neg() {
        return new Integer(-1 * number);
    }

    @Override
    public String toString() {
        if(sign() == 1)
            return "+ " + number;
        else if(sign() == -1)
            return  "- " + number*(-1);
        else
            return "";

    }

}
