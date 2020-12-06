import java.util.Stack;

//顺序栈
class MyStack<T> {
    public T[] elem;
    public int top;

    public MyStack() {
        this.elem = (T[])new Object[10];
    }

    public void push(T item) {
        if (isFull()) {
            System.out.println("溢出");
            return;
        }
        this.elem[top++] = item;
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("栈为空");
        }
        T ret = this.elem[top-1];
        this.top--;
        this.elem[top] = null;
        return ret;
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("栈为空");
        }
        return this.elem[top-1];
    }

    public boolean empty() {
        if (top == 0) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == elem.length) {
            return true;
        }else {
            return false;
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        //System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());

    }

    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        System.out.println(stack);
        System.out.println("size = " + stack.size());
        int ret = stack.pop();
        System.out.println(stack.peek());
        System.out.println(ret);
        System.out.println(stack);
        System.out.println("size = " + stack.size());
    }
}
