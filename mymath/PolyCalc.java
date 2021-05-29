package mymath;

/**
 * This class contains calculus methods applicable to the Poly class.
 * @author Trong Nguyen
 * @version 1.0
 */
public class PolyCalc {
    /**
     * This method calculates the derivative of the polynomial supplied Poly object.
     * @param poly Poly object to be differentiated.
     * @return Poly object with newly differentiated coefficients.
     */
    public static Poly differentiate(Poly poly) {
        int oldLength = poly.getCoefficient().length;
        double[] newArray = new double[oldLength];
        int degree = 1;
        for (int i = oldLength - 1; i > 0; i--) {
            newArray[i] = poly.getCoefficient()[i-1] * degree;
            degree++;
        }
        return new Poly(newArray);
    }

    /**
     * This method calculates the integral of the polynomial supplied Poly object.
     * @param poly Poly object to be integrated.
     * @return Poly object with newly integrated coefficients.
     */
    public static Poly integrate(Poly poly) {
        int oldLength = poly.getCoefficient().length;
        double[] newArray = new double[oldLength + 1];
        for (int i = oldLength; i > 0; i--) {
            newArray[newArray.length - i - 1] = poly.getCoefficient()[oldLength - i] / i;
        }
        newArray[newArray.length - 1] = 0;
        return new Poly(newArray);
    }
}
