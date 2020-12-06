import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        int[] arr = {8,4,78,5,1,9,69,45};
        mergeSortNor(arr);
        System.out.println(Arrays.toString(arr));
    }

    //前k个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : words) {
            //把每个单词出现的次数作为哈希表的值储存起来
            map.put(s,map.getOrDefault(s,0)+1);
        }
        //建小堆
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照出现频率比较
                return map.get(o1).equals(map.get(o2)) ?
                        (o1+"").compareTo((o2+"")) : map.get(o1) - map.get(o2);
            }
        });
        for (String str : map.keySet()) {
            queue.offer(str);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            ret.add(queue.poll());
        }
        Collections.sort(ret, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).equals(map.get(o2)) ?
                        o1.compareTo(o2) : map.get(o2) - map.get(o1);
            }
        });
        return ret;
    }

    //k个最接近的数
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        if (arr.length == 1) {
            ret.add(arr[0]);
            return ret;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2-x) - Math.abs(o1-x);
            }
        });
        int i = 0;
        for (; i < arr.length-1; i++) {
            if (i < k) {
                if (Math.abs(arr[i]-x) == Math.abs(arr[i+1]-x)) {
                    queue.offer(Math.min(arr[i],arr[i+1]));
                }else {
                    queue.offer(arr[i]);
                }
            }else {
                if (Math.abs(arr[i]-x) < Math.abs(queue.peek()-x)) {
                    queue.poll();
                    if (Math.abs(arr[i+1]-x) == Math.abs(arr[i]-x)){
                        queue.offer(Math.min(arr[i],arr[i+1]));
                    } else {
                        queue.offer(arr[i]);
                    }
                }
            }
        }
        if (i+1==arr.length-1 && Math.abs(arr[i+1]-x) < Math.abs(arr[i]-x)) {
            queue.offer(arr[i+1]);
        }
        int[] tmp = new int[k];
        int n = 0;
        while (!queue.isEmpty()) {
            tmp[n] = queue.poll();
            n++;
        }
        Arrays.sort(tmp);
        for (int a : tmp) {
            ret.add(a);
        }
        return ret;
    }
    //比较版本号
    public int compareVersion(String version1, String version2) {
        //通过split方法去掉字符串中的点
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n1 = s1.length;
        int n2 = s2.length;
        //遍历两个字符串数组，把每次结果赋给i1，i2，然后比较
        int i1;
        int i2;
        //遍历长度取两个数组最长的，然后每次判断是否下标超出，超出的部分用0代替
        for (int i = 0;i < Math.max(n1,n2);i++) {
            i1 = i < n1 ? Integer.parseInt(s1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(s2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        mergeSortInternal(arr,0,arr.length-1);
    }
    public static void mergeSortInternal(int[] arr,int low,int high) {
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
        while (s1 <= mid && s2 <= high) {
            if (arr[s1] < arr[s2]) {
                tmp[k++] = arr[s1++];
            }else {
                tmp[k++] = arr[s2++];
            }
        }
        //判断循环退出原因
        while (s1 <= mid) {
            tmp[k++] = arr[s1++];
        }
        while (s2 <= high) {
            tmp[k++] = arr[s2++];
        }
        //转移到原来数组
        for (int i = 0; i < tmp.length; i++) {
            arr[low+i] = tmp[i];
        }
    }
    //非递归实现归并排序
    public static void mergeSortNor(int[] arr) {
        //分组进行归并
        for (int i = 1; i < arr.length; i*=2) {
            mergeNor(arr,i);
        }
    }
    public static void mergeNor(int[] arr,int group) {
        int len = arr.length;
        //按组定义两个归并段s1-e1，s2-e2
        int s1 = 0;
        int e1 = s1+group-1;
        int s2 = e1+1;
        int e2 = s2+group-1 < len ? s2+group-1 : len-1;
        int[] tmp = new int[len];
        int k = 0;
        //保证能有两个归并段
        while (s2 < len) {
            while (s1 <= e1 && s2 <= e2) {
                if (arr[s1] < arr[s2]) {
                    tmp[k++] = arr[s1++];
                } else {
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
            s1 = e2 + 1;
            e1 = s1 + group - 1;
            s2 = e1 + 1;
            e2 = s2 + group - 1 < len ? s2 + group - 1 : len - 1;
        }
        //判断循环推出条件
        while (s1 <= len-1) {
            tmp[k++] = arr[s1++];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }
}
