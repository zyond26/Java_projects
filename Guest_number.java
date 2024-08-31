
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Guest_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        int guess;
        System.out.println("guess  0-100");

        while (true) {
            try {
                System.out.print("nhap so ");
                guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("correct!!! congratulation!!!");
                    break;
                } else if (guess < 0 || guess > 100) {
                    System.out.println("invalid . Guess again");
                } else if (guess < randomNumber) {
                    System.out.println("the number is smaller than the number you guess. Guess again");
                } else {
                    System.out.println("the number is bigger than the number you guess. Guess again");
                }
            } catch (InputMismatchException e) {
                System.out.println("chi nhap so nguyen.");
                scanner.next();
            }
        }

        scanner.close();
    }
}