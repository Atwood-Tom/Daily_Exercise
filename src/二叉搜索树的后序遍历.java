public class 二叉搜索树的后序遍历 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0){
            return true;
        }
        return helper(postorder,0,postorder.length-1);
    }

    private boolean helper(int[] postorder, int start, int end) {
        if (start>=end){
            return true;
        }
        int i=start;
        int root=postorder[end];
        for (;i<end&&root>postorder[i];i++);
        for (int j=i;j<end;j++){
            if (postorder[j]<root){
                return false;
            }
        }
        return helper(postorder,start,i-1)&&helper(postorder,i,end-1);
    }
}
