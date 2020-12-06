import javax.swing.plaf.PanelUI;
import java.util.HashMap;

public class TestDemo {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(21,21);
        hashBuck.put(31,31);
        hashBuck.put(4,43);
        hashBuck.put(5,54);
        hashBuck.put(6,65);
        hashBuck.put(7,76);
        hashBuck.put(8,8);
        System.out.println("sss");
        //hashBuck.put(80,80);
    }
}
class HashBuck {
    static class Node{
        public int data;//key
        public int value;
        public Node next;
        public Node(int data,int value) {
            this.data = data;
            this.value = value;
        }
    }
    public Node[] arr;
    public int usedSize;

    public HashBuck() {
        this.arr = new Node[10];
        this.usedSize = 0;
    }

    public void put(int key,int value) {
        //找到位置
        int index = key%this.arr.length;
        //遍历这个位置下的链表
        for(Node cur = arr[index];cur != null;cur=cur.next) {
            if (cur.data == key) {
                cur.value = value;
                return;
            }
        }
        //该链表当中没有和当前key值一样的元素,头插法
        Node node = new Node(key,value);
        node.next = this.arr[index];
        this.arr[index] = node;
        this.usedSize++;
        if (loadFactor() > 0.75) {
            resize();
        }
    }
    //计算负载因子
    public double loadFactor() {
        return this.usedSize*1.0/this.arr.length;
    }


    public void resize() {
        Node[] newArr = new Node[2*this.arr.length];
        for (int i = 0;i < this.arr.length;i++) {

            Node curNext = null;
            for (Node cur = arr[i];cur != null;cur=curNext) {
                curNext = cur.next;
                //arr[i]是一个链表
                //cur指向头结点
                int index = cur.data % newArr.length;
                cur.next = newArr[index];
                newArr[index] = cur;
            }
            this.arr = newArr;
        }
    }
    public int getValue(int key) {
        int index = key % this.arr.length;
        for (Node cur = arr[index]; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return cur.value;
            }
        }
        return -1;
    }
}
