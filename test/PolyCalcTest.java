package test;

import mymath.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This method tests the PolyCalc class.
 * @author  Trong Nguyen
 * @version 1.0
 */
public class PolyCalcTest {

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

    private static Poly p1; private final double[] expectedArray1 = {0,0,0,0,0,0,1};
    private static Poly p2; private final double[] expectedArray2 = {0,0,0,0,0,2,0};
    private static Poly p3; private final double[] expectedArray3 = {0,0,0,0,3,0,0};
    private static Poly p4; private final double[] expectedArray4 = {0,0,0,4,0,0,0};
    private static Poly p5; private final double[] expectedArray5 = {0,0,5,0,0,0,0};
    private static Poly p6; private final double[] expectedArray6 = {0,6,0,0,0,0,0};
    private static Poly p7; private final double[] expectedArray7 = {7,0,0,0,0,0,0};

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
     * Check the size of the input polynomial with the resulting polynomial after differentiate or integrate.
     */
    @Test
    public void testPolyLength() {
        assertAll("Check whether the size of array output is correct for differentiate method",
                () -> assertEquals(pA.getCoeffs().length, PolyCalc.differentiate(pA).getCoeffs().length,
                        "coefficient sizes match"),
                () -> assertEquals(pB.getCoeffs().length, PolyCalc.differentiate(pB).getCoeffs().length,
                        "coefficient sizes match")
        );

        assertAll("Check whether the size of array output is correct for integrate method",
                () -> assertEquals(pA.getCoeffs().length + 1, PolyCalc.integrate(pA).getCoeffs().length,
                        "coefficient sizes match"),
                () -> assertEquals(pB.getCoeffs().length + 1, PolyCalc.integrate(pB).getCoeffs().length,
                        "coefficient sizes match")
        );
    }


    /**
     * Test the differentiate method in the PolyCalc class.
     */
    @Test
    public void testDifferentiate() {
        Poly dNull = PolyCalc.differentiate(pNull); double[] expectedDNull = {};
        Poly dMonoZero = PolyCalc.differentiate(pMonoZero); double[] expectedDMonoZero = {0};
        Poly dMonoPos = PolyCalc.differentiate(pMonoPos); double[] expectedDMonoPos = {0};
        Poly dMonoNeg = PolyCalc.differentiate(pMonoNeg); double[] expectedDMonoNeg = {0};
        Poly dBinom1 = PolyCalc.differentiate(pBinom1); double[] expectedDBinom1 = {0,0};
        Poly dBinom2 = PolyCalc.differentiate(pBinom2); double[] expectedDBinom2 = {0,0};
        Poly dBinom3 = PolyCalc.differentiate(pBinom3); double[] expectedDBinom3 = {0,1};
        Poly dBinom4 = PolyCalc.differentiate(pBinom4); double[] expectedDBinom4 = {0,1};

        Poly d1 = PolyCalc.differentiate(p1); double[] expectedD1 = {0,0,0,0,0,0,0};
        Poly d2 = PolyCalc.differentiate(p2); double[] expectedD2 = {0,0,0,0,0,0,2};
        Poly d3 = PolyCalc.differentiate(p3); double[] expectedD3 = {0,0,0,0,0,6,0};
        Poly d4 = PolyCalc.differentiate(p4); double[] expectedD4 = {0,0,0,0,12,0,0};
        Poly d5 = PolyCalc.differentiate(p5); double[] expectedD5 = {0,0,0,20,0,0,0};
        Poly d6 = PolyCalc.differentiate(p6); double[] expectedD6 = {0,0,30,0,0,0,0};
        Poly d7 = PolyCalc.differentiate(p7); double[] expectedD7 = {0,42,0,0,0,0,0};

        Poly dA = PolyCalc.differentiate(pA); double[] expectedDA = {0,0,0,12,6,2};
        Poly dB = PolyCalc.differentiate(pB); double[] expectedDB = {0,0,0,-21,16,-3};

        assertAll("PolyCalc differentiate method testing",
                () -> assertArrayEquals(expectedDNull, dNull.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDMonoZero, dMonoZero.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDMonoPos, dMonoPos.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDMonoNeg, dMonoNeg.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDBinom1, dBinom1.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDBinom2, dBinom2.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDBinom3, dBinom3.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDBinom4, dBinom4.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedD1, d1.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedD2, d2.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedD3, d3.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedD4, d4.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedD5, d5.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedD6, d6.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedD7, d7.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDA, dA.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedDB, dB.getCoeffs(), 0.001)
        );
    }

    /**
     * Test the integrate method in the PolyCalc class.
     */
    @Test
    public void testIntegrate() {
        Poly iNull = PolyCalc.integrate(pNull); double[] expectedINull = {0};
        Poly iMonoZero = PolyCalc.integrate(pMonoZero); double[] expectedIMonoZero = {0,0};
        Poly iMonoPos = PolyCalc.integrate(pMonoPos); double[] expectedIMonoPos = {1,0};
        Poly iMonoNeg = PolyCalc.integrate(pMonoNeg); double[] expectedIMonoNeg = {-1,0};
        Poly iBinom1 = PolyCalc.integrate(pBinom1); double[] expectedIBinom1 = {0,0,0};
        Poly iBinom2 = PolyCalc.integrate(pBinom2); double[] expectedIBinom2 = {0,1,0};
        Poly iBinom3 = PolyCalc.integrate(pBinom3); double[] expectedIBinom3 = {0.5,0,0};
        Poly iBinom4 = PolyCalc.integrate(pBinom4); double[] expectedIBinom4 = {0.5,1,0};

        Poly i1 = PolyCalc.integrate(p1); double[] expectedI1 = {0,0,0,0,0,0,1,0};
        Poly i2 = PolyCalc.integrate(p2); double[] expectedI2 = {0,0,0,0,0,1,0,0};
        Poly i3 = PolyCalc.integrate(p3); double[] expectedI3 = {0,0,0,0,1,0,0,0};
        Poly i4 = PolyCalc.integrate(p4); double[] expectedI4 = {0,0,0,1,0,0,0,0};
        Poly i5 = PolyCalc.integrate(p5); double[] expectedI5 = {0,0,1,0,0,0,0,0};
        Poly i6 = PolyCalc.integrate(p6); double[] expectedI6 = {0,1,0,0,0,0,0,0};
        Poly i7 = PolyCalc.integrate(p7); double[] expectedI7 = {1,0,0,0,0,0,0,0};

        Poly iA = PolyCalc.integrate(pA); double[] expectedIA = {0,0,1,1,1,1,0};
        Poly iB = PolyCalc.integrate(pB); double[] expectedIB = {0,0,-1.75,2.66666,-1.5,4,0};

        assertAll("PolyCalc integrate method testing",
                () -> assertArrayEquals(expectedINull, iNull.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIMonoZero, iMonoZero.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIMonoPos, iMonoPos.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIMonoNeg, iMonoNeg.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIBinom1, iBinom1.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIBinom2, iBinom2.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIBinom3, iBinom3.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIBinom4, iBinom4.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedI1, i1.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedI2, i2.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedI3, i3.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedI4, i4.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedI5, i5.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedI6, i6.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedI7, i7.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIA, iA.getCoeffs(), 0.001),
                () -> assertArrayEquals(expectedIB, iB.getCoeffs(), 0.001)
        );
    }
}
