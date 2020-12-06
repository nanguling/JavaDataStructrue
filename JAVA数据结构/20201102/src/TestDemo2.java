import java.util.ArrayList;
import java.util.List;

/**
 * 装箱：（装包） 简单类型 =》包装类类型
 * 1.自动装箱
 * 2.显示装箱
 * 拆箱（拆包） 包装类类型 =》 简单类型
 * 1.自动拆箱
 * 2.显示拆箱
 *
 *
 */

public class TestDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        List<Integer> ret = list.subList(0, 2);
        System.out.println(ret);
        System.out.println("=======================");
        ret.set(0,88);
        System.out.println(ret);
        System.out.println(list);
    }

    public static void main3(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3,99);
        System.out.println(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(88);
        list2.addAll(list);
        System.out.println(list2);

        System.out.println("size:" + list2.size());
        System.out.println(list2.remove(2));
        System.out.println("size:" + list2.size());
        System.out.println(list2);
    }

    public static void main2(String[] args) {
        Integer integer = 10;
        //拆箱
        int b = integer;//自动
        double c = integer.doubleValue();//显示
    }

    public static void main1(String[] args) {
        Integer integer = new Integer(10);//显示装箱
        Integer integer1 = Integer.valueOf(10);//显示
        //[-128,127]
        Integer i = 100;//自动装箱 valueOf
        Integer i2 = 100;
        System.out.println(i == i2);

        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i3 == i4);



    }
}
