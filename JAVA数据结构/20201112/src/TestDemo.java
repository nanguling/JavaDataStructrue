import java.lang.reflect.Array;
import java.util.Arrays;

public class TestDemo {


    public static void main(String[] args) {
        int[] arr = {10,20,8,25,35,6,18,30,5,15,28};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //插入排序
    //稳定
    //时间复杂度：最好O(N)，最坏O(N^2)
    //空间复杂度：O(1)
    //特点：越有序，越快
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >=0 ; j--) {
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
    //不稳定排序
    //时间复杂度：最好O(N^1.3),最坏O(N^1.5)
    //空间复杂度O(1)
    public static void shell(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-gap;
            for (; j >=0 ; j-=gap) {
                if (arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
    public static void shellSort(int[] arr) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(arr,drr[i]);
        }
    }
    //选择排序
    //时间复杂度O(N^2)
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
    //快速排序
    //划分函数
    public static int partion(int[] nums,int start,int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] > tmp) {
                end--;
            }
            if(start >= end) {
                break;
            }else {
                nums[start] = nums[end];
            }
            while (start < end && nums[start] < tmp) {
                start++;
            }
            if(start >= end) {
                break;
            }else {
                nums[end] = nums[start];
            }
        }
        nums[start] = tmp;
        return start;
    }
    //时间复杂度O(N*logN)
    //空间复杂度O(logN)
    //不稳定排序
    public static void quick(int[] arr,int low,int high) {
        if(low >= high) return;
        int par = partion(arr,low,high);
        quick(arr,low,par-1);
        quick(arr,par+1,high);
    }
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }
}
