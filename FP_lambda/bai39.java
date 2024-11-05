package FP_lambda;

/*Bài tập 39. FP.Lambda đóng gói 1 pipeline.
Dạng khái quát của pipeline có thể viết thành dạng template:
in-out=in|->out|->...
Ví dụ:
b=f(a);
c=g(b);
d=k(c);
Có thể dùng FP để đóng gói thành 1 dạng code "siêu ngắn" sử dụng kiểu viết pipeline.
Bài tập: Chuyển code jv sau sang code sử dụng FP:
*/
/* 
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        
        // Cách 1: Truyền thống - từng bước riêng biệt
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // b = f(a)
        List<Integer> doubled = new ArrayList<>();
        for(Integer n : numbers) {
            doubled.add(n * 2);
        }
        
        // c = g(b)
        List<Integer> filtered = new ArrayList<>();
        for(Integer n : doubled) {
            if(n > 5) filtered.add(n);
        }
        
        // d = k(c)
        int sum = 0;
        for(Integer n : filtered) {
            sum += n;
        }
        
        System.out.println("Kết quả 1: " + sum);
    }
}*/

// Giải:
// Sử dụng FP pipeline:

import java.util.List;
import java.util.Arrays;

public class bai39 {
    public static void main(String[] args) {

        // Cách 2: Stream pipeline
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int result = numbers.stream()
                .map(n -> n * 2) // b = f(a) thực hiện phép nhân đôi giá trị của mỗi phần tử.
                .filter(n -> n > 5) // c = g(b) lọc các phần tử trong stream, chỉ giữ lại những phần tử có giá trị
                                    // lớn hơn 5.
                .mapToInt(n -> n) // d = k(c) // chuyển đổi Stream<Integer> thành IntStream
                .sum(); // e = h(d) // tính tổng tất cả các phần tử trong stream.

        System.out.println("Result 2: " + result);
    }
}
