public class 最大二叉树 {
    //链接:https://leetcode-cn.com/problems/maximum-binary-tree/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length==0){
            return null;
        }
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[index]<nums[i]){
                index=i;
            }
        }
        TreeNode root=new TreeNode(nums[index]);
        root.left=CreateTree(nums,0,index-1);
        root.right=CreateTree(nums,index+1,nums.length-1);
        return root;
    }

    private TreeNode CreateTree(int[] nums, int left, int right) {
        if (left>right){
            return null;
        }
        int index=left;
        for (int i=left;i<=right;i++){
            if (nums[index]<nums[i]){
                index=i;
            }
        }
        TreeNode node=new TreeNode(nums[index]);
        node.left=CreateTree(nums,left,index-1);
        node.right=CreateTree(nums,index+1,right);
        return node;
    }
}
