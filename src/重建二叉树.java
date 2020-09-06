public class 重建二叉树 {
    //链接:https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
          if (pre.length==0||in.length==0||pre.length!=in.length){
              return null;
          }
          return newBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode newBinaryTree(int [] pre,int pre_start,int pre_end,int [] in,int in_start,int in_end){
          if (pre_start>pre_end||in_start>in_end){
              return null;
          }
          TreeNode newNode=new TreeNode(pre[pre_start]);
          for (int i=in_start;i<=in_end;i++){
              if (pre[pre_start]==in[i]){
                  //pre:
                  //从[pre_start+1,pre_start+i-in_start]是左子树的前序遍历
                  //从[pre_start+1+i-in_start,pre_end]是右子树的前序遍历
                  //in:
                  //从[in_start,i)为左子树的中序遍历
                  //从[i+1,in_end]为右子树的中序遍历
                  newNode.left=newBinaryTree(pre,pre_start+1,pre_start+i-in_start,in,in_start,i-1);
                  newNode.right=newBinaryTree(pre,pre_start+1+i-in_start,pre_end,in,i+1,in_end);
                  break;
              }
          }
          return newNode;
    }
}
