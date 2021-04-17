package PolyMath;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    /**
     * accepts a Monomial argument and
     * returns a new Monomial that is the result of adding the current
     * Monomial to the argument m. The Monomials must have the same
     * exponent, otherwise the method should return Null.
     */
    public Monomial add(Monomial m){
        if(m.exponent != this.exponent)
            return null;
        //return new Monomial()
        return null;
    }

    /**
     * accepts a Monomial argument and
     * returns a Monomial that is the result of multiplication of the current
     * Monomial with the argument m.
     */
    public Monomial mult(Monomial m){
        return null;
    }

    /**
     * accepts a Scalar argument and evaluates
     * the current Monomial using s. For example, evaluating 2x^2 on the
     * scalar 2/3 yields 2 * (2/3)^2 = 8/9.
     */
    public Scalar evaluate(Scalar s){
        return null;
    }

    /**
     * returns a new Monomial which is the derivaive of the current monomial
     */
    public Monomial derivative(){
        return null;
    }

    //returns 1 for a positive coefficient and -1 otherwise
    public int sign(){
        if(this.coefficient.sign()>0)
            return 1;
        return -1;
    }

    public String toString(){
        return null;
    }
}
