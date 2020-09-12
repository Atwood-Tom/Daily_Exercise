import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序平均值 {
    //链接:https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Double> averageOfLevels(TreeNode root) {
          List<Double> list=new LinkedList<>();
          if (root==null){
              return list;
          }
          Queue<TreeNode> queue=new LinkedList<>();
          list.add((double) root.val);
          if (root.right!=null){
              queue.add(root.right);
          }if (root.left!=null){
            queue.add(root.left);
        }
          while(!queue.isEmpty()){
              queue=helper(queue,list);
          }
          return list;
    }

    private Queue<TreeNode> helper(Queue<TreeNode> queue, List<Double> list) {
          Queue<TreeNode> help=new LinkedList<>();
          int time=0;
          double sum=0;
          while(!queue.isEmpty()){
              TreeNode x=queue.remove();
              if (x==null){
                  continue;
              }
              time++;
              if (x.left!=null){
                  help.add(x.left);
              }
              if (x.right!=null){
                  help.add(x.right);
              }
              sum+=x.val;
          }
          list.add(sum/time);
          return help;
    }
}
