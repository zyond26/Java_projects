package FP_lambda;

import java.util.Scanner;

// Functional interface using generics
@FunctionalInterface
interface SumCalculator<T extends Number> {
    T calculate(T a, T b);
}

public class bai36 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SumCalculator<Double> sum = (a, b) -> a + b;
        double a, b;
        System.out.print("a: ");
        a = nhapSoDouble();
        System.out.print("b: ");
        b = nhapSoDouble();
        double result = sum.calculate(a, b);
        System.out.println("sum: " + result);
    }

    public static double nhapSoDouble() {
        double x = 0;
        while (true) {
            try {
                x = Double.parseDouble(scanner.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println(e + ":" + "...");
            }

        }
    }
}
