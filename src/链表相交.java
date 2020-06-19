import java.util.List;

public class 链表相交 {
    //链接:https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA,b=headB;
        int lengtha=0,lengthb=0;
        for (;a!=null;a=a.next,lengtha++);
        for (;b!=null;b=b.next,lengthb++);
        int length=lengtha-lengthb;
        if (length<0){
            length*=-1;
            ListNode mid=headA;
            headA=headB;
            headB=mid;
        }
        for (;length>0;length--,headA=headA.next);
        for (;headA!=headB&&headA!=null;headA=headA.next,headB=headB.next);
        return headA;
    }
}
