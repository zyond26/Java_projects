/*
 * Bài tập 21.
 * Tạo một lớp Singleton đơn giản có tên là SimpleSingleton.
 * Lớp này cần có một thuộc tính là message kiểu String.
 * Triển khai phương thức getInstance() để trả về instance duy nhất của
 * SimpleSingleton.
 * Tạo một phương thức setMessage() để đặt giá trị cho thuộc tính message.
 * Tạo một phương thức getMessage() để lấy giá trị của thuộc tính message.
 * Viết một lớp test có tên SimpleSingletonTest để kiểm tra tính duy nhất của
 * Singleton:
 * Lấy hai instance của SimpleSingleton
 * Đặt message cho instance thứ nhất
 * In ra message từ cả hai instance
 * So sánh địa chỉ bộ nhớ của hai instance
 * Chứng minh rằng cả hai instance đều tham chiếu đến cùng một đối tượng trong
 * bộ nhớ..
 */

// SimpleSingleton
class SimpleSingleton {
    private static SimpleSingleton instance;
    private String message;

    private SimpleSingleton() {
        // Private constructor to prevent instantiation
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// SimpleSingletonTest
public class Bai21 {
    public static void main(String[] args) {
        // Lấy hai instance của SimpleSingleton
        SimpleSingleton instance1 = SimpleSingleton.getInstance();
        SimpleSingleton instance2 = SimpleSingleton.getInstance();

        // Đặt message cho instance thứ nhất
        instance1.setMessage("Hello, Singleton!");

        // In ra message từ cả hai instance
        System.out.println("Message from instance1: " + instance1.getMessage());
        System.out.println("Message from instance2: " + instance2.getMessage());

        // So sánh địa chỉ bộ nhớ của hai instance
        System.out.println("Are instance1 and instance2 the same object? " + (instance1 == instance2));

        // In ra hashCode của cả hai instance để so sánh
        System.out.println("HashCode of instance1: " + instance1.hashCode());
        System.out.println("HashCode of instance2: " + instance2.hashCode());
    }
}