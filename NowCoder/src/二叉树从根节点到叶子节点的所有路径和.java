import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 二叉树从根节点到叶子节点的所有路径和 {
    //链接:https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=188&&tqId=35512&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
   public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
    public List<String> result_helper=new LinkedList<>();
    public int sumNumbers (TreeNode root) {
        // write code here
        if (root==null){
            return 0;
        }
        result_helper.clear();
        String x="";
        Helper(root,x);
        int sum=0;
        for (String i:result_helper){
            sum+=Integer.valueOf(i);
        }
        return sum;
    }

    private void Helper(TreeNode root, String x) {
        x=x+root.val;
        if (root.left==null&&root.right==null){
            result_helper.add(x);
            return;
        }
        if (root.left==null){
            Helper(root.right,x);
            return;
        }
        if (root.right==null){
            Helper(root.left,x);
            return;
        }
        Helper(root.right,x);
        Helper(root.left,x);

    }
}
