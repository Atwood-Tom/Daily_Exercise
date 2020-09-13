import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    //链接:https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new LinkedList<>();
        if (root==null){
            return result;
        }
        List<Integer> myHelpList=new LinkedList<>();
        FindPathSum(root,sum,result,myHelpList);
        return result;
    }

    private void FindPathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> myHelpList) {
        if (root==null){
            return;
        }
        myHelpList.add(root.val);
        sum-=root.val;
        if (root.left==null&&root.right==null&&sum==0){
            result.add(new LinkedList<>(myHelpList));
        }
        FindPathSum(root.left,sum,result,myHelpList);
        FindPathSum(root.right,sum,result,myHelpList);
        myHelpList.remove(myHelpList.size()-1);
    }
}
