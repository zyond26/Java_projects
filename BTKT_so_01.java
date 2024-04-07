import java.util.Scanner;

public class BTKT_so_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Nhap mot so: ");
            double number = scanner.nextDouble();
            
            if (number > 100 || number < 0) {
                System.out.println("Da thoat khoi vong lap.");
                break;
            }
        }
        
        scanner.close();
    }
}