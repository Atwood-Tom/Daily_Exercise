import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 合并K个排序链表 {
    //方法一:逐一比较
    public static ListNode mergeKLists1(ListNode[] lists){
        ListNode newhead=new ListNode(0);
        ListNode p=newhead;
        for (;!isEmptyListNode(lists);){
            int min=Integer.MAX_VALUE;
            int j=0;
            for (int i=0;i<lists.length;i++){
                if (lists[i]!=null&&lists[i].val<min){
                    j=i;
                    min=lists[i].val;
                }
            }
            p.next=lists[j];
            lists[j]=lists[j].next;
            p=p.next;
            p.next=null;
        }
        return newhead.next;
    }
    private static boolean isEmptyListNode(ListNode[] lists) {
        for(ListNode x:lists){
            if (x!=null){
                return false;
            }
        }
        return true;
    }
    //方法二:暴力求解
    public ListNode mergeKLists2(ListNode[] lists) {
        int length=0;
        for (ListNode x:lists){
            while(x!=null){
                x=x.next;
                length++;
            }
        }
        int[] arr =new int[length];
        int i=0;
        for (ListNode x:lists){
            while (x!=null) {
                arr[i]=x.val;
                x=x.next;
                i++;
            }
        }
        Arrays.sort(arr);
        ListNode newhead=new ListNode(0);
        i=0;
        for (ListNode p=newhead;i<arr.length;i++){
            p.next=new ListNode(arr[i]);
            p=p.next;
        }
        return newhead.next;
    }
    //方法三:优先队列
    public ListNode mergeKLists3(ListNode[] lists){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for (ListNode x:lists){
            while(x!=null){
                priorityQueue.add(x.val);
                x=x.next;
            }
        }
        ListNode newhead=new ListNode(0);
        ListNode p=newhead;
        while(!priorityQueue.isEmpty()){
            p.next=new ListNode(priorityQueue.poll());
            p=p.next;
        }
        return newhead.next;
    }
}
