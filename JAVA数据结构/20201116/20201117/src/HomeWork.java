import java.util.*;

public class HomeWork {
    //字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        if (s == null) return -1;
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        //遍历字符串统计每个字符出现的次数
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i),1);
            }else {
                int count = map.get(s.charAt(i))+1;
                map.put(s.charAt(i),count);
            }
        }
        //遍历哈希表，找出第一个只出现一次的字符
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if(nums1[i1] == nums2[i2] && !set.contains(nums1[i1])) {
                set.add(nums1[i1]);
                i1++;
                i2++;
            }else if (nums1[i1] < nums2[i2]) {
                i1++;
            }else {
                i2++;
            }
        }
        int[] arr = new int[set.size()];
        int i = 0;
        for (Integer val: set) {
            arr[i++] = val;
        }
        return arr;
    }
    //两个数组的交集Ⅱ
    public int[] intersect(int[] nums1, int[] nums2) {
        //先对两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;//数组1的指针
        int i2 = 0;//数组2的指针
        int[] arr = new int[Math.min(nums1.length,nums2.length)];//结果数组
        int index = 0;//结果数组的下标
        //同时遍历两个数组，值相同则放入结果集，不一样则让值小的向前走一步，直到其中一个数组遍历完成
        while (i1 < nums1.length && i2 < nums2.length) {
            //找到交集
            if (nums1[i1] == nums2[i2]) {
                arr[index++] = nums1[i1++];
                i2++;
            }else if (nums1[i1] < nums2[i2]) {
                i1++;
            }else {
                i2++;
            }
        }
        //返回结果数组的有效范围
        return Arrays.copyOfRange(arr,0,index);
    }

    //同构字符串
    //利用map一一映射的关系来寻找s和t每个字符的关系，如果构成同构字符串
    //那么他们一定满足一一映射关系，如果不满足则不是
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic1(s,t) && isIsomorphic1(t,s);
    }
    public boolean isIsomorphic1(String s, String t) {
        int len = s.length();
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0;i < len;i++) {
            if(map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i),t.charAt(i));
            }else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
class BinarySearchTree {
    //静态内部类
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }
    }
    //定义一个根节点
    static Node root;
    //添加
    public static void put(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return;
        }
        //指向cur的根节点
        Node pre = null;
        Node cur = root;
        while (cur != null) {
            //该去右边找
            if (cur.val < val) {
                pre = cur;
                cur = pre.right;
            }else if (cur.val > val) {
                //该去左边找
                pre = cur;
                cur = pre.left;
            }else {
                //数据相等不做任何操作
                return;
            }
        }
        //此时cur == null pre = cur的根节点
        if (pre.val < val) {
            //说明此时应该为pre的右子树
            pre.right = node;
        }else {
            //应该为左子树
            pre.left = node;
        }
    }
    //查找
    public static Node get(int val) {
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }else if (cur.val < val) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }
    //删除
    public static boolean remove(int val) {
        if (root == null) return false;
        Node cur = root;
        //指向cur的根节点
        Node pre = null;
        //寻找要删除的节点
        while (cur != null) {
            if (cur.val == val) {
                break;
            }else if (cur.val < val) {
                pre = cur;
                cur = pre.right;
            }else {
                pre = cur;
                cur = pre.left;
            }
        }
        //判断是否有该节点
        if (cur == null) return false;//cur为空说明没有要删除的节点
        //开始删除节点
        //1.cur没有左子树
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;//直接用cur的右子树覆盖即完成删除
            }else {
                if (cur == pre.left) {
                    pre.left = cur.right;
                }else {
                    pre.right = cur.right;
                }
            }
            //cur没有右子树
        }else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else {
                if (cur == pre.left) {
                    pre.left = cur.left;
                }else {
                    pre.right = cur.left;
                }
            }
        }else {
            //cur左右儿子都有
            //指向cur的下一个节点
            Node minCur = cur.right;
            //指向minCur的根节点
            Node minPre = null;
            //找后继节点
            while (minCur.left != null) {
                minPre = minCur;
                minCur = minPre.left;
            }
            //让后继节点直接覆盖掉cur完成删除
            cur = minCur;
            //删除掉原来的后继节点
            if (minCur == minPre.left) {
                minPre.left = minCur.right;
            }else {
                minPre.right = minCur.right;
            }
        }
        return true;
    }
    //中序遍历
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 56, 23, 5, 9, 1, 32, 41};
        for (int i = 0; i < arr.length; i++) {
            put(arr[i]);
        }
        inorder(root);
        System.out.println();
        try {
            System.out.println(get(56).val);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有找到该节点");
        }
        remove(9);
        inorder(root);
    }
}
