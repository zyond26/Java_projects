package thread;

/*Bài 42. Thread.2.Volatile cho 2 luồng ghi, đọc sử dụng cờ.
Viết một chương trình Java với hai luồng. 
Luồng thứ nhất liên tục tạo ra các số nguyên ngẫu nhiên và gán chúng cho một biến chung. 
Luồng thứ hai liên tục đọc biến chung này.Khi luồng thứ hai đọc được một số chia hết cho 24102024, nó sẽ báo hiệu cho cả hai luồng dừng lại

Giải:*/
public class bai42 {

    static int n = 0;
    static volatile boolean shouldStop = false; // volatile đảm bảo tính hiển thị giữa các luồng

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (!shouldStop) {
                n = (int) (Math.random() * 1000000); // Sinh số ngẫu nhiên cho đơn giản
                System.out.println("Luồng 1 nhập: " + n);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (!shouldStop) {
                System.out.println("Luồng 2 đọc: " + n);
                if (n % 24102024 == 0) {
                    shouldStop = true;
                    System.out.println("Luồng 2 tìm thấy số chia hết cho 24102024");
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}