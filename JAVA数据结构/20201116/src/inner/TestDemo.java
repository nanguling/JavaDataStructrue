package inner;
//内部类：
//1.实例内部类
//
//2.静态内部类
//3.匿名内部类
//4.本地内部类


//1.拿到实例内部类对象的方式：OuterClass.InnerClass innerClass = o.new InnerClass();
//2.不能在实例内部类中定义一个静态的变量，非要确定的话，定义一个在编译时期确定的值，例如常量
//3.实力内部类是否有额外的开销？ 有，OuterClass.this
//4.this是静态的 可以通过外部类的类名直接调用 OuterClass.this
//5.注意 内部类产生的字节码文件：外部类＄内部类.class
/*class OuterClass {
    public int data1 = 98;
    public int data2 = 99;
    class InnerClass {
        public int data1 = 100;
        public static final int a = 10;
        public void fun() {
            System.out.println(4);
            System.out.println(a);
            System.out.println(data2);
            System.out.println(data1);//100
            System.out.println(this.data1);//100
            System.out.println(OuterClass.this.data1);//98
        }
    }
}*/

//1.如何拿到静态内部类的实例对象：
//2.静态内类中是不可以访问外部类的非静态数据成员的，非要访问呢？
/*class OuterClass {
    public int data1 = 98;
    public int data2 = 99;
    //静态的数据成员
    static class InnerClass {
        public int data1 = 100;
        OuterClass outerClass;
        public InnerClass(OuterClass outerClass) {
            this.outerClass = outerClass;
        }
        public void fun() {
            System.out.println(4);
            System.out.println(data1);
            System.out.println(this.outerClass.data2);
        }
    }
}*/

class OutClass {
    public void fun() {
        System.out.println("fun");
    }
}

public class TestDemo {    public static void main(String[] args) {
        //匿名内部类
        new OutClass(){
            @Override
            public void fun() {
                System.out.println("sssssss");
            }
        }.fun();
    }
    /*public static void main(String[] args) {
        OuterClass o = new OuterClass();
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass(o);
        innerClass.fun();
    }*/
    /*public static void main(String[] args) {
        OuterClass o = new OuterClass();
        OuterClass.InnerClass innerClass = o.new InnerClass();
        innerClass.fun();
    }*/
}
