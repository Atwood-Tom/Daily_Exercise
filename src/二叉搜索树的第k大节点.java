import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 二叉搜索树的第k大节点 {
    //链接:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public int kthLargest1(TreeNode root, int k) {
        List<Integer> list=new LinkedList<>();
        helper(list,root);
        int[] arr =new int[list.size()];
        for (int i=0;i<arr.length;i++){
            arr[i]=list.remove(0);
        }
        Arrays.sort(arr);
        return arr[arr.length-k];
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root==null){
            return;
        }
        list.add(root.val);
        helper(list,root.left);
        helper(list,root.right);
    }

    //方法二:中序遍历二叉搜索树为递增序列
    //则中序遍历的倒序为递减序列,则可以返回遍历的第k个结点
    int time,result;
    public int kthLargest(TreeNode root, int k) {
        time=k;
        Solution(root);
        return result;
    }

    private void Solution(TreeNode root) {
        if (root==null){
            return;
        }
        Solution(root.right);
        time--;
        if (time==0){
            result=root.val;
            return;
        }
        Solution(root.left);
    }
}
