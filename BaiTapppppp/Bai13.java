package BaiTapppppp;
//Bài tập 13. Duyệt theo cách thông thường (theo chỉ số nguyên) 

import java.util.ArrayList;
import java.util.Iterator;

public class Bai13 {
    public static void main(String[] args) {
        ArrayList<String> names;
        names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
        System.out.println("Duyệt theo kiểu arraylist");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Phần tử thứ " + i + " " + names.get(i));
        }

        System.out.println("Sử dụng mảng cố định kích thước ");
        String[] mangthuong = new String[3];
        mangthuong[0] = "Alice";
        mangthuong[1] = "Bob";
        mangthuong[2] = "Charlie";
        for (int i = 0; i < mangthuong.length; i++) {

            System.out.println("Phần tử thứ " + i + " " + mangthuong[i]);
        }

    }
}
