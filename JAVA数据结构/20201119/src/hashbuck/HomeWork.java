package hashbuck;

import java.rmi.StubNotFoundException;
import java.util.HashMap;
import java.util.Objects;

/*class Student{
    public int id;

    public Student(int id) {
        this.id = id;
    }

    //重写equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    //重写hashcode方法
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

//尾插法
class MyHashBuck<K,V>{
    //节点类（静态内部类）
    static class Node<K,V>{
        public K data;
        public V value;
        public Node<K,V> next;

        public Node(K data, V value) {
            this.data = data;
            this.value = value;
        }
    }
    //定义数组存放链表
    public Node<K,V>[] arr;
    //定义有效长度
    public int usedSize;
    public MyHashBuck() {
        //初始化数组长度为10
        this.arr = new  Node[5];
        this.usedSize = 0;
    }
    //添加
    public void put(K key,V value) {
        //得到此时key的位置
        int hash = key.hashCode();
        //得到合法的下标
        int index = hash % this.arr.length;
        //遍历当前下标的链表，寻找是否有相同key
        Node<K,V> cur = arr[index];
        //判断是否第一次插入
        if (cur == null) {
            arr[index] = new Node<>(key,value);
            return;
        }
        for (;cur.next != null;cur = cur.next) {
            //此时已经有相同的key
            if (cur.data.equals(key)) {
                //替换掉原来value
                cur.value = value;
                return;
            }
        }
        //判断尾巴节点是否和key值相同
        if (cur.data.equals(key)) {
            cur.value = value;
            return;
        }
        //说明没有相同的key，直接尾插
        cur.next = new Node<>(key,value);
        this.usedSize++;
        if (loadFactor() > 0.75) {
            resize();
        }
    }
    public double loadFactor() {
        return this.usedSize*1.0 / this.arr.length;
    }
    public void resize() {
        //扩容
        Node<K,V>[] newArr = new Node[this.arr.length*2];
        //扩容之后必须重新哈希
        for (int i = 0; i < this.arr.length; i++) {

            for (Node<K,V> cur = arr[i];cur != null;cur = cur.next) {
                //得到key的新位置
                int hash = arr[i].data.hashCode();
                //得到key的新合法下标
                int index = hash % newArr.length;
                //第一次插入则直接插入
                if (newArr[index] == null) {
                    newArr[index] = cur;
                    continue;
                }
                //找到尾巴节点
                Node<K,V> newCur = newArr[index];
                while (newCur.next != null) {
                    newCur = newCur.next;
                }
                //尾插
                newCur.next = cur;
            }
        }
        this.arr = newArr;
    }
    //查找
    public V getValue(K key) {
        //得到key的位置
        int hash = key.hashCode();
        //得到合法下标
        int index = hash % this.arr.length;
        //遍历数组每个元素查找元素
        for (Node<K,V> cur = arr[index];cur != null;cur = cur.next) {
            if (cur.data.equals(key)) {
                return cur.value;
            }
        }
        return null;
    }
}

public class HomeWork {
    public static void main(String[] args) {
        Student student1 = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        Student student4 = new Student(4);
        Student student5 = new Student(5);
        Student student6 = new Student(6);
        Student student7 = new Student(7);
        MyHashBuck<Student,String> map = new MyHashBuck<>();
        map.put(student1,"sss");
        map.put(student2,"aaa");
        map.put(student3,"ccc");
        map.put(student4,"ddd");
        map.put(student5,"fff");
        map.put(student6,"eee");
        map.put(student7,"lll");
        System.out.println(map.getValue(student1));
        System.out.println(map.getValue(student2));
        System.out.println(map.getValue(student3));
        System.out.println(map.getValue(student4));
        System.out.println(map.getValue(student5));
        System.out.println(map.getValue(student6));
        System.out.println(map.getValue(student7));
    }
}*/

