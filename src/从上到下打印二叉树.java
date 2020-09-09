import java.util.LinkedList;
import java.util.Queue;

public class 从上到下打印二叉树 {
    //链接:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> myhelper=new LinkedList<>();
        queue.add(root);
        help(queue,myhelper);
        int arr[]=new int[queue.size()];
        int i=0;
        for (TreeNode x:myhelper){
            if (x==null){
                continue;
            }
            arr[i++]=x.val;
        }
        return arr;
    }

    private void help(Queue<TreeNode> queue, Queue<TreeNode> myhelper) {
        while(!queue.isEmpty()){
            TreeNode mid=queue.remove();
            if (mid==null){
                continue;
            }
            myhelper.add(mid);
            queue.add(mid.left);
            queue.add(mid.right);
        }
    }
}
