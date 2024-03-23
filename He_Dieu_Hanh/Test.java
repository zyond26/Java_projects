package He_Dieu_Hanh;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Random;
import java.util.Scanner;

public class Test {
    static int capacity;

    public Test() {
    }

    public static void main(String[] var0) {
        @SuppressWarnings("resource")
        Scanner var1 = new Scanner(System.in);
        System.out.println("nhap so luong xe toi da co the chay qua ham ");
        capacity = var1.nextInt();
        Random var2 = new Random();

        while(true) {
            Thread var3 = new Thread(new Vehicle_Spawn('A', var2.nextInt(capacity + 5) + 1));
            Thread var4 = new Thread(new Vehicle_Spawn('B', var2.nextInt(capacity + 5) + 1));
            var3.start();
            var4.start();
        }
    }
}

