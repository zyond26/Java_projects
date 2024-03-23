import java.util.*;
public class Main {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        ArrayList<Integer> list1;
        list1 = new ArrayList();
        list1.add(1);
        list1.add(9);
        list1.add(2);
        System.out.println("list1:" + list1);
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("After sorting list1:" + list1);
        
        ArrayList<Student> list2 = new ArrayList();
        Student st1 = new Student();
        st1.mark = 9;
        st1.name = "SV1";
        list2.add(st1);
        Student st2 = new Student();
        st2.mark = 6;
        st2.name = "SV2";
        list2.add(st2);
         Student st3 = new Student();
        st3.mark = 5;
        st3.name = "SV3";
        list2.add(st3);
        Collections.sort(list2);
        System.out.println("DS sv: " + list2);
        System.out.println("Ended");
    }
}