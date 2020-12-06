import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
    public int  age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(18,"a",78);
        students[1] = new Student(19,"b",98);
        students[2] = new Student(17,"c",88);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        Arrays.sort(students);
        System.out.println("=========================");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
