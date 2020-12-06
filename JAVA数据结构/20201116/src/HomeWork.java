public class HomeWork {
    public static void main(String[] args) {
        int[] arr = {7,5,45,9,26,41,2,6};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.put(arr[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        try {
            System.out.println(binarySearchTree.get(45).val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有该节点");
        }
        System.out.println(binarySearchTree.remove(9));
        binarySearchTree.inOrder(binarySearchTree.root);
    }
}
class BinarySearchTree {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    Node root = null;
    public void put(int val) {
        Node node = new Node(val);
        //第一次插入，root == null
        if(root == null) {
            root = node;
            return;
        }
        //不是第一次插入 root != null
        Node pre = null;//用来指向cur的父亲节点
        Node cur = root;
        while (cur != null) {
            //去右边找
            if (cur.val < val) {
                pre = cur;//记录下此时cur
                cur = pre.right;//cur向右节点移动
            }else if (cur.val > val) {//该去左边找
                pre = cur;
                cur = pre.left;
            }else {//已经有相等的值，则不做任何处理，直接退出
                return;
            }
        }
        //此时cur = null，pre = cur的根节点
        //判断当前val和pre的val大小，决定插入左边还是右边
        if (pre.val < val) {//插入到右节点
            pre.right = node;
        }else {//插入到左节点
            pre.left = node;
        }
    }
    public Node get(int val) {
        Node cur = root;
        while (cur != null) {
            //找到该节点
            if (cur.val == val) {
                return cur;
            }else if (cur.val < val) {//去右边找
                cur = cur.right;
            }else {//去左边找
                cur = cur.left;
            }
        }
        //说明没找到
        return null;
    }
    //删除
    public boolean remove(int val) {
        Node cur =  root;//当前结点
        Node pre = null;//当前节点的根节点
        //先找到要删除的节点
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
        //判断是否找到
        //cur为null，说明没有找到
        if (cur == null) return false;
        //说明找到了cur，开始判断cur的位置
        if (cur.left == null) {
            if (cur == root) {//是根节点
                root = cur.right;//替换
            }else {//不是根节点
                if (cur == pre.left) {
                    pre.left = cur.right;
                }else {
                    pre.right = cur.right;
                }
            }
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
        }else {//cur的左右节点都不为null
            Node minPre = cur;//指向cur下一节点的根节点
            Node minCur = cur.right;//cur的下一个节点
            while (minCur.left != null) {
                minPre = minCur;
                minCur = minPre.left;
            }
            cur.val = minCur.val;//先覆盖掉原来节点
            //判断下一节点在根节点的哪一边
            if (minCur == minPre.left) {
                minPre.left = minCur.right;//再覆盖掉原来的下一节点
            }else {
                minPre.right = minCur.right;
            }
        }
        return true;
    }
    //中序遍历
    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    //前序遍历
    public void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

