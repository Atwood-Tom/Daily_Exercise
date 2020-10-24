public class 将有序数组转化为二叉搜索树 {
    //链接:https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){
            return null;
        }
        int start=0;
        int end=nums.length-1;
        int mid=nums.length/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,start,mid-1);
        root.right=helper(nums,mid+1,end);
        return root;
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (end<start){
            return null;
        }
        int mid=(start+end+1)/2;
        TreeNode newNode=new TreeNode(nums[mid]);
        newNode.left=helper(nums,start,mid-1);
        newNode.right=helper(nums,mid+1,end);
        return newNode;
    }
}
