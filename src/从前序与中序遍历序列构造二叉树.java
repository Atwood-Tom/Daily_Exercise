public class 从前序与中序遍历序列构造二叉树 {
    //链接:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length!=inorder.length||preorder.length==0){
            return null;
        }
        int pre_start=0,pre_end= preorder.length-1,in_start=0,in_end= inorder.length-1;
        return Helper(preorder,pre_start,pre_end,inorder,in_start,in_end);
    }

    private TreeNode Helper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (pre_start>pre_end||in_start>in_end){
            return null;
        }
        TreeNode newNode=new TreeNode(preorder[pre_start]);
        for (int i=in_start;i<=in_end;i++){
            if (inorder[i]==preorder[pre_start]){
                newNode.left=Helper(preorder,pre_start+1,pre_start+i-in_start,inorder,in_start,i-1);
                newNode.right=Helper(preorder,pre_start+i-in_start+1,pre_end,inorder,i+1,in_end);
                break;
            }
        }
        return newNode;
    }
}
