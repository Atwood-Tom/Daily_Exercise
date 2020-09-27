import java.util.HashMap;

public class 从中序与后序遍历序列构建二叉树 {
    //链接:https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int x){
            this.val=x;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length!=postorder.length||postorder.length==0){
            return null;
        }
        int inorder_start=0;
        int inorder_end=inorder.length-1;
        int postorder_start=0;
        int postorder_end=postorder.length-1;
        return Helper(inorder,inorder_start,inorder_end,postorder,postorder_start,postorder_end);
    }

    private TreeNode Helper(int[] inorder, int inorder_start, int inorder_end, int[] postorder, int postorder_start, int postorder_end) {
        if (inorder_start>inorder_end||postorder_start>postorder_end){
            return null;
        }
        TreeNode newNode=new TreeNode(postorder[postorder_end]);
        for (int i=inorder_start;i<=inorder_end;i++){
            if (inorder[i]==postorder[postorder_end]){
                //对于中序遍历来说
                //[inorder_start,i-1]是他的左子树,[i+1,inorder_end]是它的右子树
                //对于后序遍历来说
                //[postorder_start,i-1-inorder_start+postorder]是它的左子树
                //[postorder_start+i-inorder_start,postorder_end-1]是它的右子树
                newNode.left=Helper(inorder,inorder_start,i-1,postorder,postorder_start,postorder_start+i-inorder_start-1);
                newNode.right= Helper(inorder,i+1,inorder_end,postorder,postorder_start+i-inorder_start,postorder_end-1);
                break;
            }
        }
        return newNode;
    }
}
