import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {
    //链接:https://www.nowcoder.com/questionTerminal/d0267f7f55b3412ba93bd35cfa8e8035
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //栈方法
        //return Solution1(listNode);

        //递归方法
        ArrayList<Integer> arrayList = new ArrayList<>();
        Solution2(listNode, arrayList);
        return arrayList;
    }
    private void Solution2(ListNode listNode, ArrayList<Integer> arrayList) {
        if (listNode==null){
            return;
        }else {
            Solution2(listNode.next,arrayList);
            arrayList.add(listNode.val);
        }
    }
    //栈方法
    private ArrayList<Integer> Solution1(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        for (ListNode p=listNode;p!=null;p=p.next){
            stack.push(p.val);
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
