import java.util.ArrayList;
import java.util.List;

public class 二叉平衡树 {
    //检验是否是二叉平衡树
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isBalance(TreeNode node){
        int left=Solution(node.left);
        int right=Solution(node.right);
        if (Math.abs(left-right)>1){
            return false;
        }
        return isBalance(node.left)&&isBalance(node.right);
    }

    private int Solution(TreeNode node) {
        if (node==null){
            return 0;
        }
        return Math.max(Solution(node.left),Solution(node.right))+1;
    }
    public static TreeNode insert(TreeNode node,int val){
        TreeNode x=new TreeNode(val);
        if (node==null){
            return x;
        }
        TreeNode pre=node;
        while(pre!=null){
            if (pre.val>val){
                if(pre.left==null){
                    pre.left=x;
                    break;
                }else {
                    pre=pre.left;
                }
            }else {
                if (pre.right==null){
                    pre.right=x;
                    break;
                }else {
                    pre=pre.right;
                }
            }
        }
        return node;
    }
    public static void printfTree(TreeNode node){
        if(node==null){
            System.out.print("null ");
            return;
        }
        System.out.print(node.val+" ");
        printfTree(node.left);
        printfTree(node.right);
    }
    public static List<Integer> list;
    public static void main(String[] args) {
        TreeNode head=null;
        head=insert(head,3);
        head=insert(head,2);
        head=insert(head,1);
        printfTree(head);
        //中序遍历的到有序链表，通过有序链表创建二叉平衡树
        list=new ArrayList<>();
        getIn(head);
        System.out.println();
        int arr[]=new int[list.size()];
        for (int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        TreeNode head2=Solution(arr,0,arr.length-1);
        printfTree(head2);
    }

    private static void getIn(TreeNode node) {
        if (node==null){
            return;
        }
        getIn(node.left);
        list.add(node.val);
        getIn(node.right);
    }

    private static TreeNode Solution(int arr[], int l, int r) {
        if (l>r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode x=new TreeNode(arr[mid]);
        x.left=Solution(arr,l,mid-1);
        x.right=Solution(arr,mid+1,r);
        return x;
    }
}
