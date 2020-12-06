package binarytree;

class BinarySearchTree {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node (int val) {
            this.val = val;
        }

    }
    Node root = null;
    public void put(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node pre = null;
        Node cur = root;
        while (cur != null) {
            if (cur.val < key) {
                pre = cur;
                cur = pre.right;
            }else if (cur.val > key) {
                pre = cur;
                cur = pre.left;
            }else {
                cur.val = key;
                return;
            }
        }
        //cur = null pre = cur的根节点
        if (pre.val < key) {
            pre.right = node;
        }else if (pre.val > key) {
            pre.left = node;
        }
    }
    //查找
    public Node findVal(int val) {
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
    //中序遍历
    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}


public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {5,25,15,65,89,41,23,74};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.put(arr[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        try {
            System.out.println(binarySearchTree.findVal(20).val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有此节点");
        }
    }
}
