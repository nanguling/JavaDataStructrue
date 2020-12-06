import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        /*int[] arr = {10,7,3,6,8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));*/
        int[] arr = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }
    //希尔排序
    public static void shellSort(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if (arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
    //增量值
    public static void shellSort(int[] arr) {
        int[] count = {5,3,1};
        for (int i = 0; i < count.length; i++) {
            shellSort(arr,count[i]);
        }
    }
    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    //堆排序
    //构建堆
    public static void createHeap(int[] arr) {
        for (int i = (arr.length-1-1)/2; i >= 0; i--) {
            adjustDown(arr,i,arr.length);
        }
    }
    //向下调整
    public static void adjustDown(int[] arr,int p,int len) {
        int c = 2*p+1;
        while (c < len) {
            if (c+1 < len && arr[c] < arr[c+1]) {
                c++;
            }
            if (arr[c] > arr[p]) {
                int tmp = arr[c];
                arr[c] = arr[p];
                arr[p] = tmp;
                p = c;
                c = 2*p+1;
            }else {
                break;
            }
        }
    }
    //排序
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int len = arr.length-1;
        int tmp = arr[len];
        while (len > 0) {
            int cur = arr[0];
            arr[0] = arr[len];
            arr[len] = cur;
            adjustDown(arr,0,len);
            len--;
        }
    }
    //快速排序
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }
    //排序
    public static void quick(int[] arr,int low,int high) {
        if (low >= high) return;
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
}
