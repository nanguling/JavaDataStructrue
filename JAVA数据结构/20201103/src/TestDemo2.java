import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyQueue {
    public Node head;
    public Node last;

    public void offer(int val) {
        Node node = new Node(val);
        if (head == null) {
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            this.last = this.last.next;
        }

    }

    public int poll() {
        int ret = this.head.val;
        if (head.next == null) {
            this.head = null;
            this.last = null;
            return ret;
        }else {
            this.head = this.head.next;
            return ret;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.head.val;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.isEmpty());
    }

    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.isEmpty());
    }
}
