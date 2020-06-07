import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//链接:https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
public class 把二叉搜索树换成累加树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(2);
        head.left=new TreeNode(1);
        head.right=new TreeNode(3);
        convertBST(head);
    }
}
