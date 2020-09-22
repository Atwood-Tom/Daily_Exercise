import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树与双向链表 {
    //链接:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root==null){
            return root;
        }
        Queue<Node> queue=new LinkedList<>();
        helper(root,queue);
        Node pre=queue.poll();
        Node Firstpre=pre;
        Node cur = pre;
        while(!queue.isEmpty()){
            cur=queue.poll();
            pre.right=cur;
            cur.left=pre;
            pre=cur;
        }
        Firstpre.left=cur;
        cur.right=Firstpre;
        return Firstpre;
    }

    private void helper(Node root, Queue<Node> queue) {
        if (root==null){
            return;
        }
        if (root.left!=null){
            helper(root.left,queue);
        }
        queue.add(root);
        if (root.right!=null){
            helper(root.right,queue);
        }
    }
}
