
/*
 * Bài tập 20.
 * Thiết kế hệ thống quản lý log sử dụng các Design Patterns: Singleton,
 * Observer, và Facade.
 * Hệ thống này đảm bảo việc ghi nhận và hiển thị thông tin log một cách hiệu
 * quả và dễ sử dụng.
 * 
 * Yêu cầu chung:
 * +Singleton Pattern: Đảm bảo lớp Logger chỉ có một instance duy nhất trong
 * suốt vòng đời ứng dụng.
 * +Observer Pattern: Cho phép "nhiều đối tượng theo dõi và nhận thông báo mỗi
 * khi có thông điệp log mới
 * được ghi nhận.
 * +Facade Pattern: Cung cấp một giao diện đơn giản (LogFacade) để các phần khác
 * của hệ thống dễ dàng ghi log mà không cần biết chi tiết bên trong.
 * 
 * Yêu cầu chi tiết:
 * +LogObserver Interface: Định nghĩa phương thức update để nhận thông báo log.
 * +ConsoleObserver: Hiển thị thông điệp log ra console.
 * +Logger: Quản lý danh sách observer và gửi thông báo mỗi khi có log mới. Có
 * các phương thức để thêm/xóa
 * observer và ghi log với các mức độ khác nhau: logInfo, logError, logDebug.
 * +LogFacade: Khởi tạo và cấu hình Logger, cung cấp các phương thức đơn giản để
 * ghi log.
 * 
 * Trong lớp Main, hàm main(): Triển khai "phần mềm"
 * Viết lệnh minh họa việc sử dụng LogFacade để ghi các thông điệp log với các
 * mức độ khác nhau
 * (thông tin, lỗi và gỡ lỗi) để thấy các thông điệp log được ghi và hiển thị ra
 * console thông qua 1
 * biến kiểu LogFacade.
 */
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface LogObserver {
    void update(String message);
}

class ConsoleObserver implements LogObserver {
    public void update(String message) {
        System.out.println(message);
    }
}

// Singleton + Observer)
class Logger {
    private static Logger instance;
    private List<LogObserver> observers = new ArrayList<>();

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void addObserver(LogObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LogObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (LogObserver observer : observers) {
            observer.update(message);
        }
    }

    public void logInfo(String message) {
        notifyObservers("INFO: " + message);
    }

    public void logError(String message) {
        notifyObservers("ERROR: " + message);
    }

    public void logDebug(String message) {
        notifyObservers("DEBUG: " + message);
    }
}

// Facade Class
class LogFacade {
    private Logger logger;

    public LogFacade() {
        this.logger = Logger.getInstance();
        this.logger.addObserver(new ConsoleObserver());
    }

    public void logInfo(String message) {
        logger.logInfo(message);
    }

    public void logError(String message) {
        logger.logError(message);
    }

    public void logDebug(String message) {
        logger.logDebug(message);
    }
}

class Bai20_designPattern {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        LogFacade logFacade = new LogFacade();

        logFacade.logInfo("1 thông điệp xử lý.");
        logFacade.logError("1 thông điệp lỗi.");
        logFacade.logDebug("1 thông điệp gỡ lỗi.");
    }
}