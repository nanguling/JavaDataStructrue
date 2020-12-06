package lambdatest;

import java.util.ArrayList;
import java.util.HashMap;

class Test{
    public void func() {
        System.out.println("func");
    }
}
@FunctionalInterface
interface NoParameterNoReturn2{
    //注意：只能有一个方法
    void test();
}
public class TestDemo2 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Apple");
        map.put(2,"book");
        map.put(3,"apple");
        map.put(4,"cat");
        /*map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.print("key:" + integer + " value:" + s +" ");
            }
        });*/
        map.forEach((integer,s) -> System.out.print("key:" + integer + " value:" + s +" "));
    }

    public static void main4(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("book");
        list.add("red");
        list.add("pink");
        //排序
        /*list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //字符串本身实现了Comparable接口
                return o1.compareTo(o2);
            }
        });*/
        list.sort((o1, o2) -> o1.compareTo(o2));
        list.forEach((s) -> System.out.print(s +" "));
    }

    public static void main3(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("book");
        list.add("red");
        list.add("pink");
        //遍历list集合
        /*list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        list.forEach((s) -> System.out.println(s));
    }

    public static void main2(String[] args) {
        int a = 99;
        //a = 999;
        NoParameterNoReturn2 np = () -> {
            //a = 88;
            System.out.println(a);
        };
        np.test();
    }

    public static void main1(String[] args) {
        final int a = 10;
        //a = 20; 匿名内部类当中访问变量的时候，这个量必须是常量或者没有发生过改变的量
        new Test(){
            public void func() {
                System.out.println("重写func");
                System.out.println(a);
            }
        }.func();
    }

}
