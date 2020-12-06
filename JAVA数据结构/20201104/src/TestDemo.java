import java.util.*;
 class SystemUtil{
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }
}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        }else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }

    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int tmp = stack.pop();
        if (minStack.peek() == tmp) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }return s2.pop();
        }
        if (!s2.empty()){
            return s2.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if(!s2.empty()) {
            return s2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

class MyStack {
    Queue<Integer> qu1;
    Queue<Integer> qu2;
    public int useSize;
    /** Initialize your data structure here. */
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (empty()) {
            qu1.offer(x);
        }else if (!qu1.isEmpty()) {
            qu1.offer(x);
        }else {
            qu2.offer(x);
        }
        this.useSize++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        int size = this.useSize;
        if (!qu1.isEmpty()) {
            for (int i = 0; i < size-1; i++) {
                    qu2.offer(qu1.poll());
            }
            this.useSize--;
            return qu1.poll();
        }else {
            for (int i = 0; i < size-1; i++) {
                qu1.offer(qu2.poll());
            }
            this.useSize--;
            return qu2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            return -1;
        }
        int size = this.useSize;
        int tmp = 0;
        if (!qu1.isEmpty()) {
            for (int i = 0; i < size; i++) {
                tmp = qu1.poll();
                qu2.offer(tmp);
            }
            this.useSize--;
        }else {
            for (int i = 0; i < size; i++) {
                tmp = qu2.poll();
                qu1.offer(tmp);
            }
            this.useSize--;
        }
        return tmp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}

public class TestDemo {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    if ((stack.peek() == '(' && ch == ')') || (stack.peek() == '[' && ch == ']') ||(stack.peek() == '{' && ch == '}')) {
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
