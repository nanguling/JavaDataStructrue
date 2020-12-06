import java.util.*;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class TestDemo {
    //旧键盘
    public void fun(String s,String t) {
        s = s.toUpperCase();
        t = t.toUpperCase();
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
                set.add(t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i)) && !set1.contains(s.charAt(i))) {
                set1.add(s.charAt(i));
                System.out.print(s.charAt(i));
            }
        }
    }

    //宝石与石头
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    //复杂链表复制
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        //map集合中存放旧节点对应新节点
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        //对应关系完成
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //只出现一次的数字
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    //统计重复数字和次数
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int num = random.nextInt(100000);
            arr[i] = num;
        }
        //1.遍历list
        for (int val:arr) {
            if (hashMap.get(val) == null) {
                hashMap.put(val,1);
            }else {
                int tmp = hashMap.get(val)+1;
                hashMap.put(val,tmp);
            }
        }

        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("重复的数字：" + entry.getKey() + " 次数：" + entry.getValue());
            }
        }
    }

    public static void main3(String[] args) {
        int[] arr = new int[100000];
        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100000);
        }*/
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int num = random.nextInt(100000);
            arr[i] = num;
        }
        System.out.println(findNum(arr));
        removeNum(arr);
        System.out.println(Arrays.toString(arr));
    }



    //去重
    public static void removeNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
    }

    //找第一个重复数据
    public static int findNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            }else {
                return arr[i];
            }
        }
        return -1;
    }


    public static void main2(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("asdc");
        set.add("sdfv");
        set.add("asdc");
        System.out.println(set);

        Iterator<String> it = set.iterator();//迭代器

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(set.size());
        it.remove();
        System.out.println(set.size());
    }

    public static void main1(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("sss",5);
        System.out.println(map.get("sss"));

    }
}
