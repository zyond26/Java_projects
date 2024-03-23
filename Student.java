public class Student implements Comparable<Student>{
    String name;
    int age;
    int mark;
    @Override
    public int compareTo(Student other) {
        return this.mark - other.mark;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String toString(){
        return this.name + "mark: " + this.mark;
    }
}