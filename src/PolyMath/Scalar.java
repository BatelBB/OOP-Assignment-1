package PolyMath;

public interface Scalar {

    public Scalar add(Scalar s) throws Exception;//accepts a scalar argument and returns a scalar which is the sum of the current scalar and the argument.
    public Scalar mul(Scalar s) throws Exception; //accepts a scalar argument and returns a scalar which is the multiplication of the current scalar and the argument.
    public Scalar addRational(Rational s) throws Exception;
    public Scalar addInteger(Integer s);
    public Scalar mulRational(Rational s) throws Exception;
    public Scalar mulInteger(Integer s);
    public Scalar power(int exponent); //accepts a scalar argument and returns a new scalar which is the scalar raised to the power of the exponent argument.
    public int sign(); //returns 1 for positive scalar, -1 for negative and 0 for 0.
    public Scalar neg(); //returns the scalar multiplied by (-1).
}