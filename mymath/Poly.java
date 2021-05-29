package mymath;

import java.lang.Math;

/**
 * This class models a polynomial of the form: Ax^(n-1) + Bx^(n-2) ... Ux^3 + Wx^2 + Yx + Z.
 * @author Trong Nguyen
 * @version 1.0
 */
public class Poly {
    /**
     * The array of coefficient of the polynomial.
     */
    private final double[] coefficient;

    /**
     * This constructor takes an array of double coefficients of size n (n > 0).
     * @param coefficient double[] for the coefficient of the polynomial.
     */
    public Poly(double[] coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * This method evaluates the polynomial with a given x.
     * @param x double value to be evaluated by the polynomial.
     * @return double value of the polynomial evaluated.
     */
    public double evaluate(double x) {
        double p = 0.0;
        int degree = 0;
        for (int i = coefficient.length - 1; i >= 0; i--) {
            p += coefficient[i] * Math.pow(x, degree);
            degree++;
        }
        return p;
    }

    /**
     * This method prints the polynomial of the form: Ax^(n-1) + Bx^(n-2) ... Ux^3 + Wx^2 + Yx + Z,
     * with 0 coefficients terms omitted.
     */
    public void printPoly() {
        StringBuilder sb = new StringBuilder();
        int degree = coefficient.length - 1;
        for (double c : coefficient) {
            if (c != 0) {
                if (c > 0 && !(sb.length() == 0)) {
                    sb.append("+ ");
                } else if (c < 0) {
                    sb.append("- ");
                }
                if (degree == 0) {
                    sb.append(Math.abs(c));
                } else {
                    sb.append(Math.abs(c)).append("x^").append(degree).append(" ");
                }
            }
            degree--;
        }
        System.out.println(sb.toString());
    }

    /**
     * This method gets the array of coefficient for the polynomial.
     * @return double[] for the coefficient of the polynomial.
     */
    public double[] getCoefficient() {
        return coefficient;
    }
}
