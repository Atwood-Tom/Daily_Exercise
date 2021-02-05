public class 链表求和 {
    //链接：https://leetcode-cn.com/problems/sum-lists-lcci/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up=0;
        ListNode newHead=new ListNode(0);
        ListNode p=newHead;
        for (;l1!=null&&l2!=null;l1=l1.next,l2=l2.next,p=p.next){
            p.next=new ListNode((l1.val+l2.val+up)%10);
            up=(l1.val+l2.val+up)/10;
        }
        if (l1==null){
            for (;l2!=null;l2=l2.next,p=p.next){
                p.next=new ListNode((l2.val+up)%10);
                up=(l2.val+up)/10;
            }
        }
        if (l2==null){
            for (;l1!=null;l1=l1.next,p=p.next){
                p.next=new ListNode((l1.val+up)%10);
                up=(l1.val+up)/10;
            }
        }
        if (up!=0){
            p.next=new ListNode(up);
        }
        return newHead.next;
    }
}
