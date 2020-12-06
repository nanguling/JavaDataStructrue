import java.util.Arrays;
import java.util.PriorityQueue;

public class TestDemo2 {
    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};

        TestHeap testHeap = new TestHeap();
        testHeap.intHeap(arr);
        System.out.println("========================");
        testHeap.push(80);
        testHeap.heapSort();
        testHeap.show();
    }

    public static void main1(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(13);
        priorityQueue.add(3);
        priorityQueue.add(8);
        priorityQueue.offer(49);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());


    }

}
