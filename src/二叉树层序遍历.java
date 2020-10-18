import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树层序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> Levels(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        List<TreeNode> helper=new ArrayList<>();
        List<TreeNode> main=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        main.add(root);
        while(!main.isEmpty()){
            TreeNode x=main.remove(0);
            if (x.left!=null){
                helper.add(x.left);
            }
            if (x.right!=null){
                helper.add(x.right);
            }
            res.add(x.val);
            if (main.isEmpty()){
                main=helper;
                helper=new ArrayList<>();
                result.add(res);
                res=new ArrayList<>();
            }
        }
        return result;
    }
}
