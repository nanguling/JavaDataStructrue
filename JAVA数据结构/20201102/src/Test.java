import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    public static List<String> func(String str1,String str2) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!str2.contains(""+str1.charAt(i))) {
                list.add(str1.charAt(i)+"");
            }
        }
        return list;
    }
    public static void main3(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<String> list = func(str1,str2);
        for (String s:list) {
            System.out.print(s);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main1(String[] args) {

        List<Student> list = new ArrayList<>();
        Student student1 = new Student("sss","1",98.5);
        Student student2 = new Student("aaa","2",98.5);
        Student student3 = new Student("xxx","3",98.5);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        for (Student student:list) {
            System.out.println(student);
        }

    }
}

class Student {
    public String name;
    public String classes;
    public double sroce;
    public Student(String name,String classes,double sroce) {
        this.name = name;
        this.classes = classes;
        this.sroce = sroce;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", sroce=" + sroce +
                '}';
    }
}
