import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 排序链表 {
    //链接:https://leetcode-cn.com/problems/sort-list/
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> mySort=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (;head!=null;mySort.add(head),head=head.next);
        head=mySort.poll();
        ListNode tail=head;
        while(!mySort.isEmpty()){
            tail.next=mySort.poll();
            tail=tail.next;
            tail.next=null;
        }
        return head;
    }

    public ListNode sortList2(ListNode head) {
        int i=0;
        ListNode p=head;
        for(;p!=null;i++,p=p.next);
        int[] arr =new int[i];
        for (i=0, p=head;p!=null&&i<arr.length;arr[i]=p.val,i++,p=p.next);
        Arrays.sort(arr);
        for (i=0,p=head;p!=null&&i<arr.length;p.val=arr[i],i++,p=p.next);
        return head;
    }
    public static void main(String[] args) {
        ListNode head=create();
        head=sortList(head);
        for (ListNode pre=head;pre!=null;pre=pre.next){
            System.out.println(pre.val);
        }
    }

    private static ListNode create() {
        Scanner sc=new Scanner(System.in);
        ListNode head=null;
        ListNode last=null;
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            if (x==-1){
                break;
            }
            if (head==null){
                head=new ListNode(x);
                last=head;
            }else {
                ListNode cur=new ListNode(x);
                last.next=cur;
                last=last.next;
            }
        }
        return head;
    }
}
