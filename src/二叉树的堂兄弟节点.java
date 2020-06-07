public class 二叉树的堂兄弟节点 {
    //链接:https://leetcode-cn.com/problems/cousins-in-binary-tree/
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
      }
    TreeNode[] nodes = new TreeNode[2];
    int[] depthes = new int[2];
    int i = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        hight(root, x, 0, null);
        hight(root, y, 0, null);
        return depthes[0] == depthes[1] && nodes[0].val != nodes[1].val;
    }

    private void hight(TreeNode root, int x, int high, TreeNode father) {
        if (root == null) return;
        if (root.val != x) {
            hight(root.left, x, high + 1, root);
            hight(root.right, x, high + 1, root);
        } else {
            nodes[i] = father;
            depthes[i] = high;
            i++;
            return;
        }
    }
}
