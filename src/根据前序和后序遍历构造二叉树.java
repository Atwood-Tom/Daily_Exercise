public class 根据前序和后序遍历构造二叉树 {
    //链接:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
    class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int x){
            this.val=x;
        }
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length!=post.length||post.length==0){
            return null;
        }
        int pre_start=0;
        int post_start=0;
        int pre_end=pre.length-1;
        int post_end=post.length-1;
        return helper(pre,pre_start,pre_end,post,post_start,post_end);
    }

    private TreeNode helper(int[] pre, int pre_start, int pre_end, int[] post, int post_start, int post_end) {
        if (pre_start>pre_end||post_start>post_end){
            return null;
        }
        TreeNode newNode=new TreeNode(post[post_end]);
        for (int i=pre_start+1;i<=pre_end;i++){
            if (pre[i]==post[post_end-1]){
                //对于前序遍历来说:
                //[pre_start+1,i-1]为根节点的左子树
                //[i,pre_end]为根节点的右子树
                //对于后序遍历来说:
                //[post_start,post_start+i-pre_start-2]为根节点的左子树
                //[post_start+i-pre_start+1,post_end-1]
                newNode.left=helper(pre,pre_start+1,i-1,post,post_start,post_start+i-pre_start-2);
                newNode.right=helper(pre,i,pre_end,post,post_start+i-pre_start-1,post_end-1);
                break;
            }
        }
        return newNode;
    }
}
