package PolyMath;

public class Rational implements Scalar {

    private final int numerator; //Mone
    private final int denominator; //Mechane

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    @Override
    public Scalar add(Scalar s) throws Exception {
       return s.addRational(this);
    }

    @Override
    public Scalar mul(Scalar s) throws Exception {
        return s.mulRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        if (s.denominator == this.denominator) {
            if(s.numerator+this.numerator==s.denominator)// 9/9 = 1
                return new Integer(1);
            else if(s.numerator+this.numerator%s.denominator==0) // 18/9 = 2
                return new Integer((s.numerator+this.numerator)/s.denominator);
            return new Rational(s.numerator + this.numerator, s.denominator); // 17/9
        }
        //the two denominators are different so we need to find the shared denominator
        int numS = s.numerator * this.denominator;
        int numThis = this.numerator * s.denominator;
        int denS = s.denominator * this.denominator;
        int denThis = this.denominator * s.numerator;

        return new Rational(numS + numThis, denS + denThis);
    }

    @Override
    public Scalar addInteger(Integer s) {
        int numS = (s.getNumber()*this.denominator)+this.numerator;
        return new Rational(numS, this.denominator);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(s.numerator * this.numerator, s.denominator * this.denominator);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(s.getNumber()*this.numerator, this.denominator);
    }

    @Override
    public Scalar power(int exponent) {
        int numeExp = this.numerator;
        int denoExp = this.denominator;
        for (int i = 0; i < exponent; i++) {
            numeExp *= this.numerator;
            denoExp *= this.denominator;
        }
        return new Rational(numeExp, denoExp);
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
    public Rational reduce() throws Exception {
        if(this.denominator == 0)
            throw new Exception("Cannot / by zero!");
        if(this.numerator%this.denominator==0) {
            if (isPrime(this.denominator))
                return new Rational(this.numerator / this.denominator, this.denominator);
            return new Rational(this.numerator / this.denominator, this.denominator / this.numerator);
        }

        //if (isPrime(this.denominator))
            return this;
        //return new Rational(this.numerator,this.denominator/)
    }

    @Override
    public String toString() {
        if(this.numerator%this.denominator==0){
            return String.valueOf(this.numerator / this.denominator);
        }
        if(sign()==-1){//if neg and does not derive
            return "-" + this.numerator + "/" + this.denominator;
        }
        return this.numerator + "/" + this.denominator;
    }

    private boolean isPrime(int n){
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
