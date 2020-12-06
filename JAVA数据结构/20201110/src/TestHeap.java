import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap () {
        this.elem = new int[10];
    }

    public void intHeap (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
        //建堆O(n*log(n))
        for (int i = (this.usedSize-1-1)/2; i >= 0; i--) {
            adjustDown(i,this.usedSize);//调整O(log(n))
        }
        System.out.println("打断点调试!");
    }
    //交换
    public void swap(int[] elem,int c,int p) {
        int tmp = elem[c];
        elem[c] = elem[p];
        elem[p] = tmp;
    }
    //向上调整
    public void adjustUp(int c) {
        int p = (c-1)/2;
        while (c > 0) {
            if (elem[c] > elem[p]) {
                swap(elem,c,p);
                c = p;
                p = (c-1)/2;
            }else {
                break;
            }
        }
    }
    //向下调整
    public void adjustDown (int p,int len) {
        int c = p*2+1;
        //判断是否有左孩子
        while (c < len) {
            //判断是否有有孩子
            if (c+1 < len && this.elem[c] < elem[c+1]) {
                c++;
            }
            //c下标所指为最大值
            if (this.elem[c] > this.elem[p]) {
                swap(elem,c,p);
                p = c;
                c = 2*p+1;
            }else {
                break;
            }
        }
    }
    //插入
    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
        adjustUp(this.usedSize-1);
        System.out.println("打断点调试！");
    }
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    //删除
    public void pop() {
        if (isEmpty()) return;
        //1.交换堆顶和最后一个元素
        swap(elem,0,this.usedSize-1);
        this.usedSize--;
        adjustDown(0,this.usedSize);
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    //返回队首
    public int peek() {
        return this.elem[0];
    }

    public void heapSort(){
        int end = this.usedSize-1;
        while (end > 0) {
            swap(this.elem,0,end);
            adjustDown(0,end);
            end--;
        }
    }

    public void show(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}
