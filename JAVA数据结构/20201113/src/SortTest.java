import java.util.Arrays;
import java.util.Stack;

public class SortTest {

    public static void main(String[] args) {
        int[] arr = {8,4,78,5,1,9,69,45};
        mergeSortNor(arr);
        System.out.println(Arrays.toString(arr));
    }

    //直接插入排序
    public static void insertSort(int[] arr,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (;j >= low;j--) {
                if (arr[j] > arr[i]) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }
    //优化快排
    //快速排序
    public static void quickSort(int[] arr) {
        //quick(arr,0,arr.length-1);
        qucikNor(arr,0,arr.length-1);
    }
    //非递归实现快排
    public static void qucikNor(int[] arr,int low,int high) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int end = arr.length-1;
        int par = partion(arr,start,end);
        if (par > low+1) {
            stack.push(start);
            stack.push(par-1);
        }
        if (par < high-1) {
            stack.push(par+1);
            stack.push(end);
        }
        while (!stack.isEmpty()) {
            end = stack.pop();
            start = stack.pop();
            par = partion(arr,start,end);
            if (par > start+1) {
                stack.push(start);
                stack.push(par-1);
            }
            if (par < end-1) {
                stack.push(par+1);
                stack.push(end);
            }
        }
    }
    //递归快排
    public static void quick(int[] arr,int low,int high) {
        //1.优化 当low和high之间的数据个数小于某个值的时候，采用直接插入排序
        //这里自定义取当他们之间数据数量小于等于100的时候，采用直接插入排序
        if (low >= high) return;
        if (high - low + 1 <= 100) {
            insertSort(arr,low,high);
            return;
        }
        //优化2.三数取中
        medianOfThree(arr,low,high);
        int par = partion(arr,low,high);
        quick(arr,0,par-1);
        quick(arr,par+1,high);
    }

    //找基准
    public static int partion(int[] arr,int start,int end) {
        int tmp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= tmp) {
                end--;
            }
            if (start >= end) {
                break;
            }else {
                arr[start] = arr[end];
            }
            while (start < end && arr[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                break;
            }else {
                arr[end] = arr[start];
            }
        }
        arr[start] = tmp;
        return start;
    }
    //三数取中
    //arr[mid] < arr[low] < arr[high]
    public static void medianOfThree(int[] arr,int low,int high) {
        int mid = (low+high)/2;
        if (arr[mid] > arr[low]) {
            swap(arr,mid,low);
        }
        if (arr[low] > arr[high]) {
            swap(arr,low,high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr,mid,high);
        }
    }
    public static void swap(int[] arr,int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    //归并排序
    //时间复杂度：0(NlogN)
    //空间复杂度：O(N)
    //稳定
    public static void mergeSort(int[] arr) {
        mergeSortInternal(arr,0,arr.length-1);
    }
    public static void mergeSortInternal(int[] arr,int low,int high){
        if (low >= high) return;
        int mid = (low+high)/2;
        //分解
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid+1,high);
        //合并
        merge(arr,low,high,mid);
    }
    public static void merge(int[] arr,int low,int high,int mid) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmp = new int[high-low+1];
        int k = 0;//tmp的下标
        //表示两个段都有数据
        while (s1 <= mid && s2 <= high) {
            if (arr[s1] <= arr[s2]) {
                tmp[k++] = arr[s1++];
            }else {
                tmp[k++] = arr[s2++];
            }
        }
        //第一个归并段还有若干个数据
        while (s1 <= mid) {
            tmp[k++] = arr[s1++];
        }
        while (s2 <= high) {
            tmp[k++] = arr[s2++];
        }
        //tmp中存放的就是归并之后有序的结果
        for (int i = 0; i < tmp.length; i++) {
            arr[low+i] = tmp[i];
        }
    }
    //非递归的归并排序
    public static void mergeNor(int[] arr,int gap) {
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < arr.length ? s2+gap-1 : arr.length-1;
        int[] tmp = new int[arr.length];
        int k = 0;
        //先判断是否有两个归并段
        while (s2 < arr.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (arr[s1] < arr[s2]) {
                    tmp[k++] = arr[s1++];
                }else {
                    tmp[k++] = arr[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[k++] = arr[s1++];
            }
            while (s2 <= e2) {
                tmp[k++] = arr[s2++];
            }
            //一组比较完毕
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < arr.length ? s2+gap-1 : arr.length-1;
        }
        while (s1 <= arr.length-1) {
            tmp[k++] = arr[s1++];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void mergeSortNor(int[] arr) {
        for (int i = 1; i < arr.length; i*=2) {
            mergeNor(arr,i);
        }
    }
}
