package LT_generic;
/*Bài tập 5.
Hãy tạo một lớp Generic trong Java để quản lý một cặp giá trị (pair) với các yêu cầu sau:
Tạo một lớp CapGiaTri<T, U> có hai thuộc tính:
giaTri1 kiểu T
giaTri2 kiểu U
Cung cấp các phương thức:
layGiaTri1(): trả về giaTri1
layGiaTri2(): trả về giaTri2
datGiaTri1(T giaTri1): đặt giá trị cho giaTri1
datGiaTri2(U giaTri2): đặt giá trị cho giaTri2
Viết một chương trình để:
Tạo một đối tượng của lớp CapGiaTri với giaTri1 là String và giaTri2 là Integer.
Đặt giá trị cho cặp đó và in ra màn hình.
 */

class CapGiaTri<T, U> {
    private T giaTri1;
    private U giaTri2;

    public T layGiaTri1() {
        return giaTri1;
    }

    public void datGiaTri1(T giaTri1) {
        this.giaTri1 = giaTri1;
    }

    public U layGiaTri2() {
        return giaTri2;
    }

    public void datGiaTri2(U giaTri2) {
        this.giaTri2 = giaTri2;
    }
}

public class Bai5_generic {
    public static void main(String[] args) {
        CapGiaTri<String, Integer> cap = new CapGiaTri<>();
        cap.datGiaTri1("Tuoi");
        cap.datGiaTri2(25);

        System.out.println("Gia tri 1: " + cap.layGiaTri1());
        System.out.println("Gia tri 2: " + cap.layGiaTri2());
    }
}