package Generic;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.awt.*;
import java.util.ArrayList;

//泛型的上界 T extends X
//T是实现了X这个接口，或者是X的子类或者本身 <T extends Comparable<T>>
class GenericAlg<T extends Comparable<T>> {
    public T maxVal(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }
}
class GenericAlg2 {
    public static<T extends Comparable<T>> T maxVal(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }
}

// ? 通配符，多出现于源码中
//和泛型的区别：
//1.通配符一般用于读取
//2.通配符不仅有上界，还有下届
//
class Myprint<T> {
    public void print(ArrayList<?> list) {
        for (Object t : list) {
            System.out.println(t);
        }
    }
}
public class TestDemo {
    public static void main2(String[] args) {
        Myprint<Integer> myprint = new Myprint<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(15);
        myprint.print(list);
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,3,56,8,1,6};
        System.out.println(GenericAlg2.maxVal(arr));
        System.out.println(GenericAlg2.<Integer>maxVal(arr));
    }

    public static void main1(String[] args) {
        Integer[] arr = {5,4,3,56,8,1,6};
        GenericAlg<Integer> genericAlg = new GenericAlg<>();
        System.out.println(genericAlg.maxVal(arr));
        System.out.println(GenericAlg2.maxVal(arr));
    }
}
