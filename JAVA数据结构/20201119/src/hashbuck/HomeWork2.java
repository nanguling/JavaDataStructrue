package hashbuck;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Objects;

public class HomeWork2 {
    public static void main(String[] args) {
        People p1 = new People(1);
        People p2 = new People(2);
        People p3 = new People(3);
        People p4 = new People(4);
        People p5 = new People(5);
        MyHashMap map = new MyHashMap();
        map.put(p1,"aaa");
        map.put(p2,"sss");
        map.put(p3,"ddd");
        map.put(p4,"fff");
        map.put(p5,"zzz");
        System.out.println(map.getValue(p1));
        System.out.println(map.getValue(p2));
        System.out.println(map.getValue(p3));
        System.out.println(map.getValue(p4));
        System.out.println(map.getValue(p5));
    }
}
class People{
    public int id;

    public People(int id) {
        this.id = id;
    }

    //重写equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id == people.id;
    }

    //重写hashCode方法
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
//头插法的泛型类哈希表
class MyHashMap<K,V>{
    //链表(静态内部类)
    static class Node<K,V>{
        public K data;//key
        public V value;//value
        public Node<K,V> next;

        public Node(K data, V value) {
            this.data = data;
            this.value = value;
        }
    }
    //定义一个数组存储单链表
    public Node<K,V>[] arr;
    //定义有效长度
    public int usedSize;

    public MyHashMap() {
        //初始化数组长度为10
        this.arr = new Node[10];
        //初始化有效长度为0
        this.usedSize = 0;
    }
    //插入
    public void put(K key,V value) {
        //找到key的位置
        int hash = key.hashCode();
        //得到合法的下标
        int index = hash % this.arr.length;
        //遍历数组查找是否已有相同的key
        for (Node<K,V> cur = this.arr[index];cur != null;cur = cur.next) {
            //此时哈希表中已有key
            if (cur.data.equals(key)) {
                //替换value值
                cur.value = value;
                return;
            }
        }
        //没有重复的key值，直接头插
        Node<K,V> node = new Node<>(key,value);
        node.next = arr[index];
        arr[index] = node;
        this.usedSize++;
        //判断负载因子大小
        if (loadFactor() > 0.75) {
            resize();//扩容
        }
    }
    //负载因子
    public double loadFactor() {
        return this.usedSize*1.0 / this.arr.length;
    }
    //扩容
    public void resize() {
        //扩容原来的2倍
        Node<K,V>[] newArr = new Node[arr.length*2];
        //遍历原数组
        for (int i = 0; i < arr.length; i++) {
            Node<K,V> curNext = null;
            for (Node<K,V> cur = arr[i];cur != null;cur = curNext) {
                //保存cur的下一节点
                curNext = cur.next;
                //找到key的位置
                int hash = cur.data.hashCode();
                //得到新的合法下标
                int index = hash % newArr.length;
                cur.next = newArr[index];
                newArr[index] = cur;
            }
        }
        //将新数组赋值给原来的数组
        this.arr = newArr;
    }
    //查找
    public V getValue(K key) {
        //找到key的位置
        int hash = key.hashCode();
        //得到合法的下标
        int index = hash % this.arr.length;
        //遍历数组查找相同的key
        for (Node<K,V> cur = this.arr[index];cur != null;cur = cur.next) {
            //此时哈希表中已有key
            if (cur.data.equals(key)) {
                return cur.value;
            }
        }
        return null;
    }
}