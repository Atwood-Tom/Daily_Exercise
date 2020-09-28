public class 合并两个有序链表 {
    //链接:https://www.nowcoder.com/practice/a479a3f0c4554867b35356e0d57cf03d?tpId=188&&tqId=35511&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
     public class ListNode {
       int val;
       ListNode next = null;
     }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
       ListNode temp1=l1;ListNode temp2=l2;
       ListNode newhead=l1.val>l2.val?l2:l1;
       ListNode tail=newhead;
       if (newhead==l1){
           temp1=temp1.next;
       }else {
           temp2=temp2.next;
       }
       while(temp1!=null&&temp2!=null){
           if (temp1.val>temp2.val){
               tail.next=temp2;
               temp2=temp2.next;
           }else {
               tail.next=temp1;
               temp1=temp1.next;
           }
           tail=tail.next;
       }
       if (temp1==null){
           tail.next=temp2;
       }else {
           tail.next=temp1;
       }
       return newhead;
    }
}
