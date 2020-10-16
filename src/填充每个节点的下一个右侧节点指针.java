import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        helperA(root);
        helperB(root);
        helperC(root);
        return root;
    }
    //递归方法
    private void helperC(Node root) {
        if (root==null||(root.left==null&&root.right==null)){
            return;
        }
        if (root.left!=null&&root.right!=null){
            root.left.next=root.right;
        }
        if (root.next!=null){
            root.right.next=root.next.left;
        }
        helperC(root.left);
        helperC(root.right);
    }
    //层序遍历
    private void helperB(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    private void helperA(Node root) {
        List<Node> main=new ArrayList<>();
        List<Node> mid=new ArrayList<>();
        main.add(root);
        while(main.size()!=0){
            Node x=main.remove(0);
            if (x.left!=null){
                mid.add(x.left);
            }
            if (x.right!=null){
                mid.add(x.right);
            }
            if (main.size()==0){
                x.next=null;
                main=mid;
                mid=new ArrayList<>();
                continue;
            }
            x.next=main.get(0);
        }
    }
}
