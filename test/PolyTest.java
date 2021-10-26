package test;

import mymath.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This method tests the Poly class.
 * @author  Trong Nguyen
 * @version 1.0
 */
public class PolyTest {

    private static Poly pNull; private final double[] nullArray = {};

    private static Poly pMonoZero; private final double[] monoZeroArray = {0};
    private static Poly pMonoPos; private final double[] monoPosArray = {1};
    private static Poly pMonoNeg; private final double[] monoNegArray = {-1};

    private static Poly pBinom1; private final double[] BinomArray1 = {0,0};
    private static Poly pBinom2; private final double[] BinomArray2 = {0,1};
    private static Poly pBinom3; private final double[] BinomArray3 = {1,0};
    private static Poly pBinom4; private final double[] BinomArray4 = {1,1};

    private static Poly pA; private final double[] expectedArrayA = {0,0,4,3,2,1};
    private static Poly pB; private final double[] expectedArrayB = {0,0,-7,8,-3,4};

    private static Poly p1; private final double[] expectedArray1 = {0,0,0,0,0,0,5};
    private static Poly p2; private final double[] expectedArray2 = {0,0,0,0,0,5,0};
    private static Poly p3; private final double[] expectedArray3 = {0,0,0,0,5,0,0};
    private static Poly p4; private final double[] expectedArray4 = {0,0,0,5,0,0,0};
    private static Poly p5; private final double[] expectedArray5 = {0,0,5,0,0,0,0};
    private static Poly p6; private final double[] expectedArray6 = {0,5,0,0,0,0,0};
    private static Poly p7; private final double[] expectedArray7 = {5,0,0,0,0,0,0};

    /**
     * Initialize Poly objects for testing.
     */
    @BeforeEach
    public void init() {
        pNull = new Poly(nullArray);
        pMonoZero = new Poly(monoZeroArray);
        pMonoPos = new Poly(monoPosArray);
        pMonoNeg = new Poly(monoNegArray);

        pBinom1 = new Poly(BinomArray1);
        pBinom2 = new Poly(BinomArray2);
        pBinom3 = new Poly(BinomArray3);
        pBinom4 = new Poly(BinomArray4);

        p1 = new Poly(expectedArray1);
        p2 = new Poly(expectedArray2);
        p3 = new Poly(expectedArray3);
        p4 = new Poly(expectedArray4);
        p5 = new Poly(expectedArray5);
        p6 = new Poly(expectedArray6);
        p7 = new Poly(expectedArray7);

        pA = new Poly(expectedArrayA);
        pB = new Poly(expectedArrayB);
    }

    /**
     * Test the null-case for the Poly object.
     */
    @Test
    public void testNullPoly() {
        double eNull = pNull.evaluate(1);
        assertEquals(0, eNull, 0.001);

        double[] cNull = pNull.getCoeffs();
        assertArrayEquals(nullArray, cNull, 0.001);
    }

    /**
     * Test the case with only one value in the Poly object array.
     */
    @Test
    public void testMonoPoly() {
        double eMonoZero = pMonoZero.evaluate(1);
        double eMonoPos = pMonoPos.evaluate(1);
        double eMonoNeg = pMonoNeg.evaluate(1);

        assertAll("Testing Monomial Evaluate Method",
                () -> assertEquals(0, eMonoZero,0.001),
                () -> assertEquals(1, eMonoPos,0.001),
                () -> assertEquals(-1, eMonoNeg,0.001)
        );

        double[] cMonoZero = pMonoZero.getCoeffs();
        double[] cMonoPos = pMonoPos.getCoeffs();
        double[] cMonoNeg = pMonoNeg.getCoeffs();

        assertAll("Testing Monomial getCoeffs Method",
                () -> assertArrayEquals(monoZeroArray, cMonoZero,0.001),
                () -> assertArrayEquals(monoPosArray, cMonoPos,0.001),
                () -> assertArrayEquals(monoNegArray, cMonoNeg,0.001)
        );
    }

    /**
     * Test the Poly object with two elements in the array.
     */
    @Test
    public void testBinomPoly() {
        double eBinom1 = pBinom1.evaluate(1);
        double eBinom2 = pBinom2.evaluate(2);
        double eBinom3 = pBinom3.evaluate(3);
        double eBinom4 = pBinom4.evaluate(4);

        assertAll("Testing Binomial Evaluate Method",
                () -> assertEquals(0, eBinom1,0.001),
                () -> assertEquals(1, eBinom2,0.001),
                () -> assertEquals(3, eBinom3,0.001),
                () -> assertEquals(5, eBinom4,0.001)
        );

        double[] cBinom1 = pBinom1.getCoeffs();
        double[] cBinom2 = pBinom2.getCoeffs();
        double[] cBinom3 = pBinom3.getCoeffs();
        double[] cBinom4 = pBinom4.getCoeffs();

        assertAll("Testing Binomial getCoeffs Method",
                () -> assertArrayEquals(BinomArray1, cBinom1,0.001),
                () -> assertArrayEquals(BinomArray2, cBinom2,0.001),
                () -> assertArrayEquals(BinomArray3, cBinom3,0.001),
                () -> assertArrayEquals(BinomArray4, cBinom4,0.001)
        );
    }

    /**
     * Test an element within a range of index of the array for Poly object.
     */
    @Test
    public void testIndexPosition() {
        double ep1 = p1.evaluate(2);
        double ep2 = p2.evaluate(2);
        double ep3 = p3.evaluate(2);
        double ep4 = p4.evaluate(2);
        double ep5 = p5.evaluate(2);
        double ep6 = p6.evaluate(2);
        double ep7 = p7.evaluate(2);

        assertAll("Testing index position",
                () -> assertEquals(5, ep1,0.001),
                () -> assertEquals(10, ep2,0.001),
                () -> assertEquals(20, ep3,0.001),
                () -> assertEquals(40, ep4,0.001),
                () -> assertEquals(80, ep5,0.001),
                () -> assertEquals(160, ep6,0.001),
                () -> assertEquals(320, ep7,0.001)
        );

    }

    /**
     * Test Poly class evaluate method.
     */
    @Test
    public void testEvaluate() {
        double eA = pA.evaluate(2);
        double eB = pB.evaluate(3);

        assertAll("Poly evaluation method test",
                () -> assertEquals(49.0, eA, 0.001),
                () -> assertEquals(-122.0, eB, 0.001)
        );
    }

    /**
     * Test Poly class getCoeffs method.
     */
    @Test
    public void testGetCoeffs() {
        double[] cA = pA.getCoeffs();
        double[] cB = pB.getCoeffs();

        assertAll("Poly getCoeffs method test",
                () -> assertArrayEquals(expectedArrayA, cA),
                () -> assertArrayEquals(expectedArrayB, cB)
        );
    }
}
