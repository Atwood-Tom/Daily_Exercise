import java.util.Arrays;

public class 对链表进行插入排序 {
    //链接:https://leetcode-cn.com/problems/insertion-sort-list/
    public ListNode insertionSortList1(ListNode head) {
        int i=0;
        for (ListNode p=head;p!=null;p=p.next,i++);
        int arr[]=new int[i];
        i = 0;
        for ( ListNode p=head; i < arr.length; i++,p=p.next) {
            arr[i]=p.val;
        }
        Arrays.sort(arr);
        i=0;
        for (ListNode p=head;p!=null;i++,p=p.next){
            p.val=arr[i];
        }
        return head;
    }
    public ListNode insertionSortList2(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode node=new ListNode(Integer.MIN_VALUE);
        for (ListNode cur=head;cur!=null;cur=cur.next){
            ListNode insert=new ListNode(cur.val);
            ListNode a=node;
            for (;a.next!=null;a=a.next){
                if (a.val<=insert.val&&a.next.val>=insert.val){
                    insert.next=a.next;
                    a.next=insert;
                    break;
                }
            }
            if (a.next==null){
                a.next=insert;
            }
        }
        return node.next;
    }
    public ListNode insertionSortList3(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode start = new ListNode(Integer.MIN_VALUE);
        ListNode first = start;
        first.next = head;
        ListNode cur = head.next;
        while(cur!=null) {
            ListNode end = head;
            ListNode tmp = cur.next;
            //System.out.println(cur.val);
            while(end.next!=cur) {
                end = end.next;
            }
            while(cur.val>head.val&&head.next!=cur) {
                head = head.next;
                first = first.next;
            }
            if(cur.val<=head.val) {
                first.next = cur;
                cur.next = head;
                end.next = tmp;
            }
            head = start.next;
            first = start;
            cur = tmp;

        }
        return start.next;
    }
}
