public class 树的子结构 {
    //链接:https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //采用先序遍历的方式进行逐个结点的比较
        return (A != null && B != null) &&
                (Solution(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //判断是否是子结构
    public boolean Solution(TreeNode A, TreeNode B){
        //子树为空了，即判断完成了
        if(B == null)   return true;
        //父树为空了，小树还没判断完毕
        // 父树的值不等于子树的值
        // 也即不存在子结构
        if(A == null || A.val != B.val)   return false;

        //查看子树相应的结点是否等于对应的子树中的结点的值
        return Solution(A.left, B.left) && Solution(A.right, B.right);
    }
}
