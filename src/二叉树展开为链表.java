public class 二叉树展开为链表 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left==null){
                root=root.right;
            }else {
                TreeNode p=root.left;
                while(p.right!=null){
                    p=p.right;
                }
                p.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }
}
