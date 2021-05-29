package mymath;

import java.util.Arrays;
import java.util.Scanner;

public class CalcUI {
    public void Gui() {
        System.out.println("Welcome to the PolyCalc App!");
        System.out.println("""
                This application has three basic polynomial calculus functions:
                 -> Evaluate\s
                 -> Derivative\s
                 -> Integrate""");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coefficients of the polynomial separated by space: ");
        System.out.println("For example: 3.0x^2 + 2.0x^1 + 1.0, would be: 3 2 1");
        System.out.print(">>> ");
        String str = sc.nextLine();
        // Converts string integers separated with spaces to an array of doubles
        double[] p = Arrays.stream(str.split(" ")).mapToDouble(Double::parseDouble).toArray();
        Poly poly = new Poly(p);

        boolean validPoly = false;
        boolean validFunction = false;
        while (!validPoly) {
            System.out.print("Polynomial >>> "); poly.printPoly();
            System.out.println("Input correct? [y/n]");
            String input = sc.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                validPoly = true;
            } else if (input.equals("X") || input.equals("x")) {
                System.out.println("Exiting. Good-bye!");
                System.exit(1);
            } else {
                System.out.print(">>> ");
                str = sc.nextLine();
                p = Arrays.stream(str.split(" ")).mapToDouble(Double::parseDouble).toArray();
                poly = new Poly(p);
                validFunction = false;
            }
            while (validPoly && !validFunction) {
                System.out.println("""
                    Select one of the following functions:
                     [e] Evaluate\s
                     [d] Derivative\s
                     [i] Integrate\s
                     [b] Enter new polynomial\s
                     [x] Exit the program""");
                System.out.print(">>> ");
                sc = new Scanner(System.in);
                String function = sc.nextLine();
                switch (function) {
                    case "e" -> {
                        System.out.print("x = ");
                        int x = sc.nextInt();
                        double result = poly.evaluate(x);
                        System.out.println("Evaluate:"); poly.printPoly();
                        System.out.println("with x = " + x + " >>> " + result);
                    }
                    case "d" -> {
                        poly = PolyCalc.differentiate(poly);
                        System.out.print("Differentiate: ");
                        poly.printPoly();
                    }
                    case "i" -> {
                        poly = PolyCalc.integrate(poly);
                        System.out.print("Integrated: ");
                        poly.printPoly();
                    }
                    case "b" -> {
                        validFunction = true;
                        validPoly = false;
                    }
                    case "x" -> {
                        System.out.println("Exiting. Good-bye!");
                        System.exit(1);
                    }
                    default -> System.out.println("Must select a function!");
                }
            }
        }
    }
}
