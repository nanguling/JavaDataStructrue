import org.omg.CORBA.Object;

/**
 * 泛型:
 * class MyArrayList<T>  <T>：这是一个占位符，表示当前类是泛型类
 * 意义：
 * 1.可以进行类型的自动检查
 * 2.自动类型转换
 *
 * 坑：
 * 1.泛型不能去new一个泛型类型的数组 new T[]
 * 2.简单类型不能作为泛型类型参数，只能使用包装类
 * MyArrayList<int> myArrayList1 = new MyArrayList<int>();
 * 3.泛型类型的参数不参与类型的组成
 *
 * 面试问题：
 *      泛型是怎么编译的？
 *      擦除机制：擦除为Object，不是替换
 *      泛型是在编译时期的一个动作，它只存在于编译时期
 * @param <T>
 */
class MyArrayList1<T> {
    public T[] elem;
    public int useSize;

    public MyArrayList1() {
        this.elem = (T[])new Object[10];
    }

    public void add(T data) {
        this.elem[this.useSize++] = data;
    }

    public T getPos(int pos) {
        return this.elem[pos];
    }
}


public class TestGenirc {
    public static void main(String[] args) {
        /*MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2.3);
        myArrayList.add("hello");*/

        MyArrayList1<String> myArrayList = new MyArrayList1<>();
        myArrayList.add("hello");
        myArrayList.add("world");
        myArrayList.add("ssss");

        String s = myArrayList.getPos(2);
        System.out.println(s);

        MyArrayList1<Integer> myArrayList2 = new MyArrayList1<>();
        myArrayList2.add(1);
        myArrayList2.add(2);
        myArrayList2.add(3);

        //MyArrayList<int> myArrayList1 = new MyArrayList<int>();


    }
}
