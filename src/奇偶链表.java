public class 奇偶链表 {
    //链接：https://leetcode-cn.com/problems/odd-even-linked-list/
    public ListNode oddEvenList(ListNode head) {
        ListNode a=new ListNode(0);
        ListNode b=new ListNode(0);
        ListNode atail=a;
        ListNode btail=b;
        int time=1;
        for (ListNode p=head;p!=null;time++){
            if (time%2==1){
                atail.next=p;
                atail=atail.next;
                p=p.next;
                atail.next=null;
            }else {
                btail.next=p;
                btail=btail.next;
                p=p.next;
                btail.next=null;
            }
        }
        atail.next=b.next;
        return a.next;
    }
}
