package PolyMath;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient){
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
    public Monomial add(Monomial m) throws Exception {
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
        if(m.coefficient != this.coefficient)
            return null;
        return new Monomial(this.exponent+m.exponent, m.coefficient);
    }

    /**
     * accepts a Scalar argument and evaluates
     * the current Monomial using s. For example, evaluating 2x^2 on the
     * scalar 2/3 yields 2 * (2/3)^2 = 8/9.
     */
    public Scalar evaluate(Scalar s) throws Exception {
        return this.coefficient.mul(s.power(exponent));
    }

    /**
     * returns a new Monomial which is the derivaive of the current monomial
     */
    public Monomial derivative() throws Exception {
        if(this.exponent == 0)
            return new Monomial(exponent, new Integer(exponent));
        return new Monomial(exponent-1,this.coefficient.mul(new Integer(exponent)));
    }

    //returns 1 for a positive coefficient and -1 otherwise
    public int sign(){
        if(this.coefficient.sign()>0)
            return 1;
        return -1;
    }


    @Override
    public String toString(){

        String coef = coefficient.toString();

        if(coef.equals("0"))
            return "";
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

    private boolean isOne(String s){
        return s.equals("+1") || s.equals("-1");

    }

}
