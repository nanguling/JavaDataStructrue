import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;
import org.omg.CORBA.INTERNAL;

import javax.naming.InsufficientResourcesException;
import java.util.*;

public class HomeWork {


    //查找和最小的k对数字
    int[][] arr;
    int useSize;
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> ret = new ArrayList<>();
        arr = new int[n1*n2][2];
        int index = 0;
        if (n1 == 0 || n2 == 0 || k == 0) return ret;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                List<Integer> list = new ArrayList<>();
                arr[index][0] = nums1[i];
                arr[index][1] = nums2[j];
                index++;
            }
        }
        if (k >= n1*n2) {
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i][0]);
                list.add(arr[i][1]);
                ret.add(list);
            }
            return ret;
        }
        //构建一个堆
        createHeap(k);
        //开始遍历
        int i = k;
        while ( i < arr.length) {
            if ((arr[k][0]+arr[k][1]) < peek()) {
                pop();
                push(arr[k][0],arr[k][1]);
                heapSort();
                i++;
            }else {
                i++;
            }
        }
        for (int j = 0; j < k; j++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[j][0]);
            list.add(arr[j][1]);
            ret.add(list);
        }
        return ret;
    }
    public void swap(int[][] arr,int c,int p) {
        int tmp1 = arr[c][0];
        int tmp2 = arr[c][1];
        arr[c][0] = arr[p][0];
        arr[c][1] = arr[p][1];
        arr[p][0] = tmp1;
        arr[p][1] = tmp2;
    }
    public void createHeap(int k) {
        this.useSize = k;
        for (int i = (useSize-1-1)/2; i < k; i++) {
            adjustDown(i,k);
        }
    }
    public void adjustDown(int p,int len) {
        int c = 2*p+1;
        while (c < len) {
            if (c+1 < len && arr[c][0]+arr[c][1] < arr[c+1][0]+arr[c+1][1]) {
                c++;
            }
            if (arr[c][0]+arr[c][1] > arr[p][0]+arr[p][1]) {
                swap(arr,c,p);
                p = c;
                c = 2*p+1;
            }else {
                break;
            }
        }
    }
    public int peek(){
        return arr[0][0]+arr[0][1];
    }
    public void pop(){
        int tmp1 = arr[0][0];
        int tmp2 = arr[0][1];
        arr[0][0] = arr[useSize-1][0];
        arr[0][1] = arr[useSize-1][1];
        arr[useSize-1][0] = tmp1;
        arr[useSize-1][1] = tmp2;
        useSize--;
        adjustDown(0,useSize);
    }
    public void push(int val1,int val2){
        arr[useSize][0] = val1;
        arr[useSize][1] = val2;
        useSize++;
        adjustUp(useSize-1);
    }
    public void adjustUp(int c){
        int p = (c-1)/2;
        while (c > 0) {
            if (arr[c][0]+arr[c][1] > arr[p][0]+arr[p][1]) {
                swap(arr,c,p);
                c = p;
                p = (c-1)/2;
            }else {
                break;
            }
        }
    }
    public void heapSort(){
        int end = this.useSize-1;
        while (end > 0) {
            swap(arr,0,end);
            adjustDown(0,end);
            end--;
        }
    }

    public List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ret;
        int arr[][] = new int[nums1.length*nums2.length][2];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                arr[index][0] = nums1[i];
                arr[index][1] = nums2[j];
                index++;
            }
        }
        Arrays.sort(arr,(o1, o2) -> (o1[0]+o1[1]) - (o2[0]+o2[1]));

        for (int i = 0; i < Math.min(k,arr.length); i++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i][0]);
            list.add(arr[i][1]);
            ret.add(list);
        }
        return ret;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        k = Math.min(k, nums1.length * nums2.length); //注意k的取值
        if (k == 0) return res;

        Queue<int[]> Q = new PriorityQueue<>(k, (o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]);
        for (int e1 : nums1)
            for (int e2 : nums2) {
                if (Q.size() < k) {
                    Q.offer(new int[]{e1, e2});
                } else if (e1 + e2 <= Q.peek()[0] + Q.peek()[1]) {
                    Q.poll();
                    Q.offer(new int[]{e1, e2});
                }
            }
        while (k-- > 0) {
            int[] e = Q.poll();
            res.add(0, Arrays.asList(e[0], e[1]));
        }
        return res;
    }

    //最后一块石头得重量
    //通过srot排序每次让数组最后两个元素相减，值小的元素用0代替，然后再排序，直到只剩下一个元素
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        Arrays.sort(stones);
        while (stones[stones.length-2] != 0) {
            stones[stones.length-1] = stones[stones.length-1] - stones[stones.length-2];
            stones[stones.length-2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length-1];
    }
}
