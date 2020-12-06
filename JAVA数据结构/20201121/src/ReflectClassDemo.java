import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectClassDemo {
    //反射得到当前学生对象
    public static void reflectNewInstance() {
        try {
            //得到Class对象
            Class<?> classStudent = Class.forName("Student");

            //得到学生对象实例
            Student student = (Student) classStudent.newInstance();
            System.out.println("获得学生对象的实例：" + student);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //反射当前私有构造方法
    public static void reflectPrivateConstructor() {
        try {
            //创建Class对象
            Class<?> classStudent = Class.forName("Student");

            //得到私有方法，注意传入对应的参数
            Constructor<?> dcs = classStudent.getDeclaredConstructor(String.class,int.class);

            //如果得到的是私有的,要使用的话
            //必须使用setAccessible 将其设置为 true
            dcs.setAccessible(true);

            //得到学生对象
            Student student = (Student) dcs.newInstance("mike",25);
            System.out.println("获得私有构造函数且修改姓名和年龄:" + student);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //反射私有属性
    public static void reflectPrivateField() {
        try {
            //获得Class对象
            Class<?> classStudent = Class.forName("Student");

            //获得类中私有属性
            Field field = classStudent.getDeclaredField("name");

            //私有属性变为true
            field.setAccessible(true);

            //创建学生对象
            Student student = (Student) classStudent.newInstance();

            //field.set(修改的属性的对象的引用，修改的值)
            field.set(student,"小明");

            //get(这个对象的某个属性)
            //通过反射调用属性
            String name = (String) field.get(student);
            System.out.println("反射私有属性修改了name：" + name);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //反射私有方法
    public static void reflectPrivateMethod() {
        try {
            //创建Class对象
            Class<?> classStudent = Class.forName("Student");

            //获得私有方法
            Method method = classStudent.getDeclaredMethod("function",String.class);
            System.out.println("私有方法的方法名为：" + method.getName());
            //
            method.setAccessible(true);

            //创建学生对象
            Student student =(Student) classStudent.newInstance();
            //通过反射调用方法
            method.invoke(student,"我是给私有方法传的参数");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectPrivateMethod();
    }
}
