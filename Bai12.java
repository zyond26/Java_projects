// Bài tập 12. Các kiểu dữ liệu Collection và Iterator duyệt tổng quát các đối tượng Collection.

import java.util.ArrayList;
import java.util.Iterator;

public class Bai12 {
    public static void main(String[] args) {
        ArrayList<String> names;
        names = new ArrayList<>();
        names.add("Mai");
        names.add("Lan");
        names.add("Binh");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}