import java.util.Scanner;

public class 奇升偶降链表 {
    /**
     * [1] 链表，奇数位置按序增长，偶数位置按序递减，如何能实现链表从小到大？
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int arr[]=new int[sc.nextInt()];
            if(arr.length==0){
                continue;
            }
            for (int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            ListNode head=new ListNode(arr[0]);
            ListNode tail=head;
            for (int i=1;i<arr.length;i++){
                tail.next=new ListNode(arr[i]);
                tail=tail.next;
            }
            head=Solution(head);
            for (ListNode p=head;p!=null;p=p.next){
                System.out.print(p.val+" ");
            }
            System.out.println();
        }
    }

    private static ListNode Solution(ListNode head) {
        //将链表按照奇偶重新拆分
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
        a=a.next;
        b=b.next;
        //将偶链表逆转
        b=reverseList(b);

        //合并两个有序链表
        return mergeTwoLists(a,b);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre=head;
        ListNode cur=null;
        ListNode newHead=null;
        for (;pre!=null;){
            ListNode next=pre.next;
            if (next==null){
                newHead=pre;
            }
            pre.next=cur;
            cur=pre;
            pre=next;
        }
        return newHead;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a=l1;
        ListNode b=l2;
        ListNode newHead=new ListNode(0);
        ListNode tail=newHead;
        for (;a!=null&&b!=null;){
            if (a.val>b.val){
                tail.next=b;
                b=b.next;
                tail=tail.next;
            }else {
                tail.next=a;
                a=a.next;
                tail=tail.next;
            }
        }
        while(a!=null){
            tail.next=a;
            a=a.next;
            tail=tail.next;
        }
        while(b!=null){
            tail.next=b;
            b=b.next;
            tail=tail.next;
        }
        return newHead.next;
    }
}
