package BaiTapppppp;
// Bài tập 3. Phần OOP, luyện tập với HashMap

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Bai3_hashmap {
    public static void main(String[] args) {
        // Create a new HashMap
        HashMap<String, Integer> ageMap = new HashMap<>();
        // Add key-value pairs to the HashMap
        ageMap.put("John", 25);
        ageMap.put("Emily", 30);
        ageMap.put("Michael", 22);
        ageMap.put("Sophia", 28);
        // Create an iterator for the HashMap's entry set
        Iterator<Map.Entry<String, Integer>> iterator;
        iterator = ageMap.entrySet().iterator();
        // Iterate through the HashMap using the iterator
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String name = entry.getKey();
            int age = entry.getValue();
            System.out.println(name + "'s age: " + age);
        }
        System.out.println("nhập xâu khóa từ bàn phím: ");
        String st;
        try (Scanner scanner = new Scanner(System.in)) {
            st = scanner.nextLine();
        }
        // System.out.println(st);
        iterator = ageMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String name = entry.getKey();
            if (st.contains(name)) {
                int age = entry.getValue();
                System.out.println(name + "'s age: " + age);

            }

        }

    }
}