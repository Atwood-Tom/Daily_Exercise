import java.util.HashMap;

public class 二叉树的坡度 {
    //链接:https://leetcode-cn.com/problems/binary-tree-tilt/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum=0;
    public int findTilt(TreeNode root) {
        sum=0;
        if (root==null){
            return sum;
        }
        Helper(root);
        return sum;
    }

    private int Helper(TreeNode root) {
        if (root==null){
            return 0;
        }
        int x=Helper(root.left);
        int y= Helper(root.right);
        int z=x-y;
        if (z<=0){
            z*=-1;
        }
        sum+=z;
        return x+y+root.val;
    }
}
