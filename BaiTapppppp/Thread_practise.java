package BaiTapppppp;
// Q2.41.

// Xác định các phần code trong ví dụ sau tương ứng với các khái niệm lập trình sau: Lập trình hàm,
//  Thread (luồng), và Lập trình không đồng bộ.

import java.util.function.Function;
import java.util.concurrent.CompletableFuture;

public class Thread_practise extends Thread {

    @Override
    public void run() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Task completed!");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
        });

        future.join();
        System.out.println("Doing other work...");

        Function<Integer, Integer> doubleIt = x -> x * 2; // Gán hàm cho biến

        int doubledValue = doubleIt.apply(5); // Gọi hàm được gán cho biến
        System.out.println(doubledValue);

        Thread_practise thread = new Thread_practise();
        thread.start();

    }
}