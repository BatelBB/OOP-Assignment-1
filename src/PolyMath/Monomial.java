package PolyMath;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient){
        if(exponent < 0)
            throw new IllegalArgumentException("Exponent cannot be negative");
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public int getExponent(){
        return exponent;
    }

    /**
     * accepts a Monomial argument and
     * returns a new Monomial that is the result of adding the current
     * Monomial to the argument m. The Monomials must have the same
     * exponent, otherwise the method should return Null.
     */
    public Monomial add(Monomial m)  {
        if(m.exponent == 0 )
            m.exponent =+ this.exponent;
        if(this.exponent == 0)
            this.exponent =+ m.exponent;
        if(m.exponent != this.exponent)
            return null;
        return new Monomial(m.exponent, this.coefficient.add(m.coefficient));
    }

    /**
     * accepts a Monomial argument and
     * returns a Monomial that is the result of multiplication of the current
     * Monomial with the argument m.
     */
    public Monomial mult(Monomial m){
        return new Monomial(this.exponent+m.exponent, m.coefficient.mul(this.coefficient));
    }

    /**
     * accepts a Scalar argument and evaluates
     * the current Monomial using s. For example, evaluating 2x^2 on the
     * scalar 2/3 yields 2 * (2/3)^2 = 8/9.
     */
    public Scalar evaluate(Scalar s)  {
        return this.coefficient.mul(s.power(exponent));
    }

    /**
     * returns a new Monomial which is the derivaive of the current monomial
     */
    public Monomial derivative()  {
        if(this.exponent == 0)
            return new Monomial(exponent, new Integer(exponent));
        return new Monomial(exponent-1,this.coefficient.mul(new Integer(exponent)));
    }

    //returns 1 for a positive coefficient and -1 otherwise
    public int sign(){
        return this.coefficient.sign();
    }


    @Override
    public String toString(){

        String coef = coefficient.toString();

        if(coef.equals("0"))
            return "0";
        if(exponent == 0){
            return coef;
        }
        else if(exponent == 1){
            if(isOne(coef))
                return coef.substring(0,1) + "x";
            else
                return coef + "x";
        }

        if(isOne(coef))
            return coef.substring(0,1) + "x^" + exponent;

        return coef + "x^" + exponent;

    }

    /**
     * Checks if the string is + or minus 1
     * @param s the string to checks
     * @return returns true if it's equal to +1 or -1
     */
    private boolean isOne(String s){
        return s.equals("+1") || s.equals("-1");

    }

}
