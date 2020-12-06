
    public class TestDemo {
        public static void main(String[] args) {
            BinaryTree b = new BinaryTree();
            Node root = b.createTree();
            b.preOrderTraversal(root);
            System.out.println();
            b.inOrderTraversal(root);
            System.out.println();
            b.postOrderTraversal(root);
            System.out.println();

            b.getSize1(root);
            System.out.println("遍历思路的节点个数： " + BinaryTree.size);
            System.out.println("子问题思路的节点个数： " + b.getSize2(root));

            b.getLeafSize1(root);
            System.out.println("遍历思路的叶子个数： " + BinaryTree.leafSize);
            System.out.println("子问题思路的叶子个数： " + b.getLeafSize2(root));

            System.out.println("子问题思路的第k层节点个数： " + b.getKLevelSize(root, 3));

            System.out.println("二叉树的高度为： " + b.getHeight(root));

            System.out.println(b.find(root,'G'));

            b.levelOrderTraversal(root);
        }
}
