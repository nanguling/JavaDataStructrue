

import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode (int val) {
        this.val = val;
    }
}
public class TestDemo {
    //非递归实现二叉树的前中后序遍历
    // 前序遍历
    void preOrderTraversal(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }

    }
    // 中序遍历
    void inOrderTraversal(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    // 后序遍历
    void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();//D
            if (cur.right == null || cur.right == prev) {
                System.out.print(cur.val + " ");
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }
}
