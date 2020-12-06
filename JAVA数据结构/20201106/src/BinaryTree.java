import java.util.*;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

    public class BinaryTree{
        public Node createTree() {
            Node A = new Node('A');
            Node B = new Node('B');
            Node C = new Node('C');
            Node D = new Node('D');
            Node E = new Node('E');
            Node F = new Node('F');
            Node G = new Node('G');
            Node H = new Node('H');
            A.left = B;
            A.right = C;
            B.left = D;
            B.right = E;
            E.right = H;
            C.left = F;
            C.right = G;
            return A;
        }

        // 前序遍历
        void preOrderTraversal(Node root){
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        // 中序遍历
        void inOrderTraversal(Node root){
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }

        // 后序遍历
        void postOrderTraversal(Node root){
            if (root == null) {
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }

        // 遍历思路-求结点个数
        static int size = 0;
        void getSize1(Node root){
            if (root == null) return;
            size++;
            getSize1(root.left);
            getSize1(root.right);
        }

        // 子问题思路-求结点个数
        int getSize2(Node root){
            int i = 0;
            if (root == null) {
                return 0;
            }
            return getSize2(root.left) + getSize2(root.right)+1;
        }

        // 遍历思路-求叶子结点个数
        static int leafSize = 0;
        void getLeafSize1(Node root){
            if (root == null) return;
            if (root.left == null && root.right == null) leafSize++;
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }

        // 子问题思路-求叶子结点个数
        int getLeafSize2(Node root){
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            return getLeafSize2(root.left) + getLeafSize2(root.right);

        }

        // 子问题思路-求第 k 层结点个数
        int getKLevelSize(Node root,int k){
            if (root == null) return 0;
            if (k == 1) return 1;
            return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
        }

        // 获取二叉树的高度
        int getHeight(Node root){
            if (root ==null) return 0;
            return Math.max(getHeight(root.left)+1,getHeight(root.right)+1);
        }

        // 查找 val 所在结点，没有找到返回 null
        // 按照 根 -> 左子树 -> 右子树的顺序进行查找
        // 一旦找到，立即返回，不需要继续在其他位置查找
        Node find(Node root, char val){
            Node newRoot = null;
            if (root == null) return null;
            if (root.val == val) {
                newRoot = root;
            }else {
                if (newRoot == null) {
                    newRoot = find(root.left,val);
                }
                if (newRoot == null) {
                    newRoot = find(root.right,val);
                }
            }
            return newRoot;
        }

        //检查两棵树是否相同
        public boolean isSameTree(Node p, Node q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

        //另一棵树的子树
        public boolean isSubtree(Node s, Node t) {
            if (t == null) return true;
            if (s == null) return false;
            return isSubtree(s.left,t) || isSubtree(s.right,t) || isSameTree(s,t);
        }

        //平衡二叉树
        public boolean isBalanced(Node root) {
            if (root == null) return true;
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        //对称二叉树
        public boolean isSymmetric(Node root) {
            return isSymmetric(root,root);
        }
        public boolean isSymmetric(Node r1,Node r2) {
            if (r1 == null && r2 == null) return true;
            if (r1 == null || r2 == null) return false;
            if (r1.val != r2.val) return false;
            return isSymmetric(r1.left,r2.right) && isSymmetric(r1.right,r2.left);
        }

        // 层序遍历
        void levelOrderTraversal(Node root) {
            if (root == null) return;
            Queue<Node> ret = new LinkedList<>();
            ret.offer(root);
            while (!ret.isEmpty()) {
                Node cur = ret.poll();
                if (cur == null) continue;
                System.out.print(cur.val + " ");
                ret.offer(cur.left);
                ret.offer(cur.right);
            }
        }
        //层序遍历 带返回值
        public List<List<Character>> levelOrder(Node root) {
            List<List<Character>> ret = new ArrayList<>();
            if (root == null) return ret;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                List<Character> list = new ArrayList<>();
                int size = queue.size();
                while (size > 0) {
                    Node cur = queue.poll();
                    list.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    size--;
                }
                ret.add(list);
            }
            return ret;
        }
}


