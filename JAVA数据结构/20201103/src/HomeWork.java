import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class MyCircularDeque {
    public int[] elem;
    public int front;
    public int rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.elem = new int[k+1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        //这里为什么要让front先移动再放元素呢？
        //原因是因为要保证front和rear之间差一个空位
        this.front = (front-1 + this.elem.length) % this.elem.length;
        this.elem[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front+1) % this.elem.length;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        this.rear = (rear-1 + this.elem.length) % this.elem.length;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[(rear-1 + this.elem.length) % this.elem.length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (this.rear+1) % this.elem.length == this.front;
    }
}

public class HomeWork {

}
