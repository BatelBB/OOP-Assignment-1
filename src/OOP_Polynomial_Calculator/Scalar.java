package OOP_Polynomial_Calculator;

public interface Scalar {

    public Scalar addition(Scalar s);
    public Scalar multiplication(Scalar s);
    public Scalar addRational(Rational s);
    public Scalar addInteger(Integer s);
    public Scalar mulRational(Rational s);
    public Scalar mulInteger(Integer s);
    public Scalar power(int exponent);
    public int sign();
}
