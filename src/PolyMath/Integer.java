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
        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        return new Rational(s.getNumerator() + this.number * s.getDenominator(), s.getDenominator()).reduce();
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(number + s.number);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(s.getNumerator() * this.number, s.getNumerator()).reduce();
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
        String s = "";
        if(sign() == 0)
            return s;
        else if(sign() == 1){
            s += "+";
        }
        else
            s += "-";

        if(this.number == 1 || this.number == -1)
            return s;
        else
            return s + " " + number;


    }

}