import sun.awt.image.ImageWatched;

import java.util.*;

public class HomeWork {
    //二叉树的最大宽度
    //层序遍历二叉树，保存每个节点的下标值，根节点为i，左节点为2*i，右节点为2*i+1
    //每次遍历一层更新最大宽度为当前最右边的节点下标减去最右边的节点下标再加一
    //最后输出最大宽度即可
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        queue.offer(root);
        int ret = 1;//初始宽度为1
        index.add(1);//将节点下标保存
        //开始层序遍历
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                TreeNode cur = queue.poll();
                //当前节点下标
                Integer curIndex = index.removeFirst();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    //保存当前节点下标
                    index.add(curIndex*2);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    index.add(curIndex*2+1);
                }
            }
            if (index.size() >= 2) {//当size等于1时即保存的当前宽度值，不需要改变
                ret = Math.max(ret,index.getLast() - index.getFirst() + 1);
            }
        }
        return ret;
    }

    //判断一个二叉树是否为完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isNull = false;//创建标记，标记是否遍历到null
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur != null) {
                    //如果再还未遍历完之前出现null，肯定不是完全二叉树，返回false
                    if (isNull) return false;
                    q.offer(cur.left);
                    q.offer(cur.right);
                }else {
                    isNull = true;
                }
            }
        }
        return true;
    }

    //递增顺序查找树
    //给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，
    //并且每个结点没有左子结点，只有一个右子结点
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> ret = new LinkedList<>();
        ret = increasingBST(root,ret);
        return ret.get(0);
    }
    public TreeNode prev;
    public List<TreeNode> increasingBST(TreeNode root,List<TreeNode> ret) {
        if (root.left != null) {
            increasingBST(root.left,ret);
        }
        root.left = null;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        ret.add(root);
        if (root.right != null) {
            increasingBST(root.right,ret);
        }
        return ret;
    }

    //合并二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);//求左子树的和
        t1.right = mergeTrees(t1.right,t2.right);//求右子树的和
        return t1;
    }

}
