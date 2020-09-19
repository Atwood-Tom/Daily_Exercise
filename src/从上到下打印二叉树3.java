import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 从上到下打印二叉树3 {
    //链接:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new LinkedList<>();
        }
        Deque<TreeNode> deque=new LinkedList<>();
        Deque<TreeNode> helper=new LinkedList<>();
        List<Integer> result=new LinkedList<>();
        List<List<Integer>> end=new LinkedList<>();
        deque.addLast(root);
        for (int i=2;!deque.isEmpty();){
            TreeNode x=deque.pollLast();
            result.add(0,x.val);
            if (i%2==0){
                if (x.right!=null){
                    helper.addLast(x.right);
                }
                if (x.left!=null)  helper.addLast(x.left);
            }else {
                if (x.left!=null)  helper.addLast(x.left);
                if (x.right!=null) helper.addLast(x.right);
            }
            if (deque.isEmpty()){
                deque=new LinkedList<>(helper);
                helper.clear();
                end.add(result);
                result=new LinkedList<>();
                i++;
            }
        }
        return end;
    }
}
