import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 实现二叉树先序_中序_后序遍历 {
    //链接:https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=188&&tqId=35510&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
    public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x){
        this.val=x;
    }
  }
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> out=new ArrayList<>();
        int arr[][]=new int[3][];
        //先序遍历
        preorder(root,pre);
        arr[0]=helper(pre);
        //中序遍历
        inorder(root,in);
        arr[1]=helper(in);
        //后序遍历
        outorder(root,out);
        arr[2]=helper(out);
        return arr;
    }

    private void outorder(TreeNode root, List<Integer> result) {
        if (root==null){
            return;
        }
        outorder(root.left,result);
        outorder(root.right,result);
        result.add(root.val);
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
       inorder(root.right,result);
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root==null){
            return;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }

    private int[] helper(List<Integer> result) {
        int part[]=new int[result.size()];
        int j=0;
        for (Integer i:result){
            part[j]=i;
            j++;
        }
        return part;
    }
}
