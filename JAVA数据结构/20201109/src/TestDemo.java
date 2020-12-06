import org.omg.CORBA.TRANSACTION_MODE;

import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo {
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> ret = new LinkedList<>();
        ret.offer(root);
        while(!ret.isEmpty()) {
            TreeNode cur = ret.poll();
            if (cur == null) break;
            ret.offer(cur.left);
            ret.offer(cur.right);
        }
        for (int i = 0; i < ret.size(); i++) {
            if (ret.poll() != null) return false;
        }
        return true;
    }

    //给定二叉树的前序遍历，输出中序遍历
    int i = 0;
    public TreeNode createTree(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            i++;
        }
        return root;
    }

    //最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        /*if (left != null && right != null) return root;
        if (left != null) return left;
        return right;*/
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    //将二叉搜索树转换成双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert2(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
    public TreeNode prev;//保存上一节点
    public void Convert2(TreeNode root) {
        if (root == null) return;
        Convert2(root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        Convert2(root.right);
    }

    //二叉树创建字符串
    //没有儿子则不需要括号
    //没有左儿子，则左儿子用括号代替，右儿子加括号
    //没有右儿子，左儿子加括号就行
    //有两个儿子，都加括号
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        /*//没有儿子
        if(t.left == null && t.right == null) return t.val+"";
        //没有左儿子
        if (t.left == null) return t.val + "()" + "(" + tree2str(t.right) + ")";
        //没有右儿子
        if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        //有两个儿子
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";*/
        StringBuilder sb  = new StringBuilder();
        tree2str(t,sb);
        return sb.toString();
    }
    public void tree2str(TreeNode t,StringBuilder sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left == null) {
            if (t.right == null) {
                return;
            }else {
                sb.append("()");
            }
        }else {
            sb.append("(");
            tree2str(t.left,sb);
            sb.append(")");
        }
        if (t.right == null) {
            return;
        }else {
            sb.append("(");
            tree2str(t.right,sb);
            sb.append(")");
        }
    }

    //前序遍历和中序遍历构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                //分割
                //前序遍历中的左子树
                int[] leftPre = Arrays.copyOfRange(preorder,1,i+1);
                //前序遍历中的右子树
                int[] rightPre = Arrays.copyOfRange(preorder,i+1,preorder.length);
                //中序遍历中的左子树
                int[] leftIn = Arrays.copyOfRange(inorder,0,i);
                //中序遍历中的右子树
                int[] rightIn = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left = buildTree(leftPre,leftIn);
                root.right = buildTree(rightPre,rightIn);
                break;
            }
        }
        return root;
    }

    //中序遍历和后序遍历构造二叉树
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length-1]) {
                int[] leftIn = Arrays.copyOfRange(inorder,0,i);
                int[] rightIn = Arrays.copyOfRange(inorder,i+1,inorder.length);
                int[] leftPos = Arrays.copyOfRange(postorder,0,i);
                int[] rightPos = Arrays.copyOfRange(postorder,i,postorder.length-1);
                root.left = buildTree(leftIn,leftPos);
                root.right = buildTree(rightIn,rightPos);
                break;
            }
        }
        return root;
    }
    public int preIndex = 0;
    public TreeNode buildTreeChild(int[] preorder,
                                   int[] inorder,int inbegin,int inend) {
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inorderIndex = findInoderIndexOfRoot(inorder,
                inbegin,inend,preorder[preIndex]);
        preIndex++;
        root.left = buildTreeChild(preorder,
                inorder,inbegin,inorderIndex-1);
        root.right = buildTreeChild(preorder,
                inorder,inorderIndex+1,inend);
        return root;
    }

    public int findInoderIndexOfRoot(int[] inorder,
                                     int inbegin,int inend,int val) {
        for (int j = inbegin; j <= inend; j++) {
            if(inorder[j] == val) {
                return j;
            }
        }
        return -1;
    }


    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeChild(preorder,inorder,
                0,inorder.length-1);
    }
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null && inorder == null) return null;
        if (preorder.length == 0 && inorder.length == 0) return null;
        TreeNode ret = buildTree(preorder,
                inorder,0,inorder.length-1);
        return ret;
    }*/
    //public int preIndex = 0;
    public TreeNode buildTree(int[] preorder,
                              int[] inorder,int inBegin,int inEnd) {
        if (inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = func(inorder,inBegin,inEnd,preorder[preIndex]);
        preIndex++;
        root.left = buildTree(preorder,inorder,inBegin,index-1);
        root.right = buildTree(preorder,inorder,index+1,inEnd);
        return root;
    }
    public int func(int[] inorder,int i,int size,int val) {
        for (int j = i; j <= size; j++) {
            if (inorder[i] == val) return j;
        }
        return -1;
    }
}
