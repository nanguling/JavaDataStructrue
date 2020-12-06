package Generic;

//1.泛型可以进行自动类型检查
//2.泛型可以进行自动类型转换
//重点：
//1.泛型的编译：擦除机制
//2.泛型的类型不参与类型的组成
//3.泛型的参数不能是简单类型
class MyArrayList<T>{
    public T[] elem;
    public int usesize;

    public MyArrayList() {
        this.elem = (T[])new Object[10];
    }

    public void push(T val) {
        this.elem[this.usesize] = val;
        this.usesize++;
    }
    public T get() {
        return this.elem[0];
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.push(1);
        myArrayList.push(2);
        System.out.println(myArrayList.get());
    }
}
