public class 两个链表的第一个公共节点 {
    //链接:https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a=length(headA);
        int b=length(headB);
        int step=a>b?a-b:b-a;
        if (a>b){
            while(step>0){
                headA=headA.next;
                step--;
            }
        }else {
            while(step>0){
                headB=headB.next;
                step--;
            }
        }
        for (;headA!=null&&headB!=null&&headA!=headB;headA=headA.next,headB=headB.next);
        return headA;
    }

    private int length(ListNode headA) {
        ListNode x=headA;
        int length=0;
        while(x!=null){
            x=x.next;
            length++;
        }
        return length;
    }
}
