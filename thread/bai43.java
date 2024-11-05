package thread;

/* 
Bài tập 43. Thread.2.Lock cho 2 luồng ghi, đọc sử dụng cơ chế lock.

Viết chương trình Java sử dụng 2 thread để in các số từ 1 đến 20, trong đó:
+Thread thứ nhất chỉ in các số chẵn
+Thread thứ hai chỉ in các số lẻ
+Các số phải được in ra theo thứ tự tăng dần
+Yêu cầu sử dụng cơ chế đồng bộ hóa với lock để đảm bảo 2 thread hoạt động luân phiên nhau

Giải:*/
public class bai43 {
    private static final int MAX_NUMBER = 20;
    private static Object lock = new Object();
    private static boolean isEvenTurn = true;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= MAX_NUMBER; i += 2) {
                synchronized (lock) {
                    while (!isEvenTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even Number from evenThread: " + i);
                    isEvenTurn = false;
                    lock.notify();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= MAX_NUMBER; i += 2) {
                synchronized (lock) {
                    while (isEvenTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd Number from oddThread: " + i);
                    isEvenTurn = true;
                    lock.notify();
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}