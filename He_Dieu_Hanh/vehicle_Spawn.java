package He_Dieu_Hanh;

import java.util.Random;

class Vehicle_Spawn implements Runnable {
    private char gateName;
    private int number;
    static int key = 0;

    static int queueA = 0, queueB = 0;

    public Vehicle_Spawn(char gateName, int number) {
        this.gateName = gateName;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            Thread.sleep((random.nextInt(50000) + 1) * 1000);
            System.out.println("co " + number + " xe dang den cong " + gateName);
            if (gateName == 'A') {
                key = 1;
                queueA += number;
                System.out.println("so xe dang doi o cong A la " + queueA);
                @SuppressWarnings("unused")
                Tunnel gateA = new Tunnel(gateName);
            } else {
                key = 0;
                queueB += number;
                System.out.println("so xe dang doi o cong B la " + queueB);
                @SuppressWarnings("unused")
                Tunnel gateB = new Tunnel(gateName);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
