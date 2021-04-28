package PolyMath;

public class Rational implements Scalar {

    private int numerator; //Mone
    private int denominator; //Mechane

    public Rational(int numerator, int denominator) {
        if(denominator == 0)
            throw new IllegalArgumentException("Denominator can't be 0");

        if(numerator < 0 && denominator < 0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else if(numerator < 0 || denominator < 0) {
            this.numerator = -1 * Math.abs(numerator);
            this.denominator = Math.abs(denominator);
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }

    @Override
    public Scalar add(Scalar s)  {
        if(s == null)
            throw new IllegalArgumentException("Scalar can't be null");
       return s.addRational(this);
    }

    @Override
    public Scalar mul(Scalar s)  {
        if(s == null)
            throw new IllegalArgumentException("Scalar can't be null");
        return s.mulRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        if(s == null)
            throw new IllegalArgumentException("Rational can't be null");
        return new Rational(this.numerator * s.denominator + this.denominator * s.numerator, this.denominator * s.denominator).reduce();
    }


    @Override
    public Scalar addInteger(Integer s) {
        if(s == null)
            throw new IllegalArgumentException("Integer can't be null");
        int numS = (s.getNumber()*this.denominator)+this.numerator;
        return new Rational(numS, this.denominator).reduce();
    }

    @Override
    public Scalar mulRational(Rational s) {
        if(s == null)
            throw new IllegalArgumentException("Rational can't be null");
        return new Rational(s.numerator * this.numerator, s.denominator * this.denominator).reduce();
    }

    @Override
    public Scalar mulInteger(Integer s) {
        if(s == null)
            throw new IllegalArgumentException("Integer can't be null");
        return new Rational(s.getNumber()*this.numerator, this.denominator).reduce();
    }

    @Override
    public Scalar power(int exponent) {
        if(numerator == 0)
            return this;

        Rational r;

        if(exponent < 0) {
            r = new Rational(this.denominator, this.numerator).reduce();
            exponent *= -1;
        }
        else
            r = this.reduce();

        return new Rational((int)Math.pow(r.numerator, exponent), (int)Math.pow(r.denominator, exponent)).reduce();
    }

    @Override
    public int sign() {
        if (this.denominator > 0 && this.numerator > 0) {
            return 1;
        } else if ((this.denominator < 0 && this.numerator > 0) || (this.numerator < 0 && this.denominator > 0)) {
            return -1;
        } else //both equal to 0
            return 0;
    }

    @Override
    public Scalar neg() {
        if (sign() == 1)
            return new Rational(this.numerator * (-1), this.denominator);
        else //already negative or 0
            return this;

    }

    //returns a new Rational which is the rational in its lowest form
    public Rational reduce() {
        if(numerator == 0)
            return this;

        int gcd = findGCD(numerator, denominator);
        return new Rational(numerator/gcd, denominator/gcd);
    }


    @Override
    public String toString() {
        Rational r = this.reduce();

        if(r.numerator == 0)
            return "0";
        if(r.denominator==1){
            return new Integer(r.numerator).toString();
        }
        if(r.sign()==-1){//if neg and does not derive
            return "-" + (-1)*r.numerator + "/" + r.denominator;
        }
        return r.numerator + "/" + r.denominator;
    }

    /**
     * Calculates the biggest divider
     * @param x numerator
     * @param y denominator
     * @return the biggest divider
     */
    private static int findGCD(int x, int y)
    {
        int r=0, a, b;
        a = Math.max(x, y); // a is greater number
        b = Math.min(x, y); // b is smaller number
        r = b;
        while(a % b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
}
