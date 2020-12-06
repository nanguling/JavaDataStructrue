package demo;

import java.lang.reflect.Constructor;

//枚举里面都是对象
//自己写的枚举类，会默认继承于Enum类 values方法为什么没在Enum里
//枚举的构造方法默认私有的
//通过反射可以拿到枚举中的私有方法，不能拿到枚举对象
public enum TestDemo2 {
    //枚举对象
    RED("红色",1),BLACK("黑色",2),GREEN("绿色",19);
    String color;
    int ordinal;

    TestDemo2(String color,int ordinal) {
        this.color = color;
        this.ordinal = ordinal;
    }
    public static TestDemo2 getEnumKey(int key) {
        for (TestDemo2 t : TestDemo2.values()) {
            if (t.ordinal == key) {
                return t;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            //创建Class对象
            Class<?> classEnum = Class.forName("demo.TestDemo2");
            //得到私有构造方法，注意传入参数
            Constructor<?> dcs = classEnum.getDeclaredConstructor(String.class,int.class,String.class,int.class);
            //修改访问权限为true
            dcs.setAccessible(true);
            //创建对象
            TestDemo2 testDemo2 =(TestDemo2) dcs.newInstance("粉色",666);
            System.out.println("获得枚举的私有构造函数：" + testDemo2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        TestDemo2[] testDemo2s = TestDemo2.values();
        for (int i = 0; i < testDemo2s.length; i++) {
            System.out.println(testDemo2s[i].ordinal());
        }
        System.out.println(TestDemo2.valueOf("RED"));
        //比较序号
        System.out.println(BLACK.compareTo(GREEN));
    }
    public static void main1(String[] args) {
        TestDemo2 testDemo2 = TestDemo2.BLACK;
        switch (testDemo2) {
            case RED:
                System.out.println("red");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case GREEN:
                System.out.println("green");
                break;
            default:
                break;
        }
    }

}
