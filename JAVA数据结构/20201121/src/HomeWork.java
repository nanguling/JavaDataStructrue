import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.contains(3);
        set.contains(2);
        set.add(2);
        set.contains(2);
        set.remove(2);
        set.contains(2);
    }
    //连续数组
    //给定一个标记count，当前元素为1则++，为0则--，初始map添加-1下标0元素
    //当count的值在map中的时候，判断当前区间长度，直到得到最大的区间长度
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        //map存放每个元素及他们的下标
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);//map将-1下标放0
        int res = 0;//每次打擂台得到最大的区间
        int count = 0;//标记当前元素
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                count++;
            }else {
                count--;
            }
            //当前count可能为0，即0和1数量相同
            if (map.containsKey(count)) {
                //判断，如果0和1的数量相同，那么他们的区间长度一定一次比一次大
                res = Math.max(res,i-map.get(count));
            }else {
                map.put(count,i);
            }
        }
        return res;
    }

    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        //存放每个元素及出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val,map.getOrDefault(val,0)+1);
            //如果当前元素出现的次数超过1次，那么直接返回true
            if (map.get(val) > 1) {
                return true;
            }
        }
        return false;
    }

    //最常见的单词
    public String mostCommonWord(String paragraph, String[] banned) {
        //用以存放禁用单词，方便后续比较
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        //给段落添加标点符号
        paragraph += ".";
        //用来存放每个单词及出现的次数
        Map<String,Integer> map = new HashMap<>();
        //存放每个单词
        StringBuilder sb = new StringBuilder();
        //初始化最大次数为0，然后打擂台模式依次比较
        int max = 0;
        String res = null;
        for (char c : paragraph.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
                //一直拼接直到遇见标点符号或者空格
                continue;
            }
            //一个单词拼接完成
            if (sb.length() > 0) {
                if (!set.contains(sb.toString().toLowerCase())) {
                    map.put(sb.toString().toLowerCase(), map.getOrDefault(sb.toString().toLowerCase(),0) + 1);
                    //得到当前单词出现的次数
                    int count = map.get(sb.toString().toLowerCase());
                    if (count > max) {
                        max = count;
                        res = sb.toString().toLowerCase();
                    }
                }
            }
            //初始化sb
            sb = new StringBuilder();
        }
        return res;
    }
}

//设计哈希映射
class MyHashMap {
    static class Node{
        public int data;
        public int value;
        public Node next;

        public Node(int data, int value) {
            this.data = data;
            this.value = value;
        }
    }
    public Node[] arr;
    public int usedSize;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.arr = new Node[500];
        this.usedSize = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        //得到合法下标
        int index = key % this.arr.length;
        //判断是否已有key
        for (Node cur = arr[index];cur != null;cur = cur.next) {
            if (cur.data == key) {
                //已有key则替换掉原来value
                cur.value = value;
                return;
            }
        }
        //没有key
        Node node = new Node(key,value);
        node.next = arr[index];
        arr[index] = node;
        this.usedSize++;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % this.arr.length;
        for (Node cur = this.arr[index];cur != null;cur = cur.next) {
            if (cur.data == key) {
                return cur.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % this.arr.length;
        Node pre = this.arr[index];
        if (pre == null) return;
        if (pre.data == key) {
            this.arr[index] = pre.next;
            this.usedSize--;
            return;
        }
        Node cur = pre.next;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                this.usedSize--;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }
}

//设计哈希集合
class MyHashSet {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node[] arr;
    public int usedSize;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.arr = new Node[500];
        this.usedSize = 0;
    }

    public void add(int key) {
        //得到合法下标
        int index = key % this.arr.length;
        for (Node cur = this.arr[index];cur != null;cur = cur.next) {
            if (cur.val == key) {
                return;
            }
        }
        Node node = new Node(key);
        node.next = this.arr[index];
        this.arr[index] = node;
        this.usedSize++;
    }

    public void remove(int key) {
        int index = key % this.arr.length;
        Node pre = this.arr[index];
        if (pre == null) return;
        if (pre.val == key) {
            this.arr[index] = pre.next;
            this.usedSize--;
            return;
        }
        Node cur = pre.next;
        while (cur != null) {
            if (cur.val == key) {
                pre.next = cur.next;
                this.usedSize--;
                return;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % this.arr.length;
        for (Node cur = this.arr[index];cur != null;cur = cur.next) {
            if (cur.val == key) {
                return true;
            }
        }
        return false;
    }
}

