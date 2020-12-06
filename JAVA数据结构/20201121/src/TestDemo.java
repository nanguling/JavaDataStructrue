class Student{
    //私有属性name
    private String name = "tom";
    //公有属性age
    public int age = 20;
    //不带参数的构造方法
    public Student() {
        System.out.println("student");
    }

    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("student(String,int)");
    }
    private void eat() {
        System.out.println("eating");
    }
    public void sleep() {
        System.out.println("sleeping");
    }
    private void function(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        //1.第一种方式
        Student student = new Student();
        Class<?> c1 = student.getClass();
        //2.第二种方式
        Class<?> c2 = Student.class;
        //3.第三种方式
        //括号里面写路径
        Class<?> c3 = null;
        try {
            c3 = Class.forName("Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //不管以什么方式生成Class对象，Class有且仅有一个
        //这三个引用指向的是同一个Class对象
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c3 == c2);
    }
}
