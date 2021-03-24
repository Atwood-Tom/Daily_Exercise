public class 有序链表转化二叉搜索树 {
    //链接:https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      public TreeNode sortedListToBST(ListNode head) {
          int num=0;
          for (ListNode p=head;p!=null;p=p.next,num++);
          int[] arr =new int[num];
          int i=0;
          for (ListNode p=head;p!=null;arr[i]=p.val,i++,p=p.next);
          return Solution(arr,0,num-1);
    }

    private TreeNode Solution(int[] arr, int l, int r) {
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
