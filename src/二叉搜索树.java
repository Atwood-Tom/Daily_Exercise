public class 二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public TreeNode root = null;

    //查找
    public boolean contain(Integer key) {
        TreeNode cur = root;
        while (cur != null) {
            int k = key.compareTo(cur.val);
            if (k == 0) {
                return true;
            } else if (k < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    //插入
    public boolean insert(Integer key) {
        if (root == null) {
            TreeNode x = new TreeNode(key);
            root = x;
            return true;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        int mid = 0;
        while (cur != null) {
            mid = key.compareTo(cur.val);
            if (mid == 0) {
                throw new RuntimeException("二叉搜索树不可以出现重复数值");
            } else if (mid > 0) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        if (mid < 0) {
            parent.left = new TreeNode(key);
        } else {
            parent.right = new TreeNode(key);
        }
        return true;
    }

    //删除
    public boolean delete(Integer key) {
        TreeNode cur = root;
        TreeNode parent = null;
        int cmp = 0;
        while (cur != null) {
            cmp = key.compareTo(cur.val);
            if (cmp == 0) {
                Myremove(cur, parent);
                return true;
            } else if (cmp > 0) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }

    private void Myremove(TreeNode cur, TreeNode parent) {
        if (cur.left == null && cur.right == null) {
            if (root == cur) {
                root = null;
            } else if (cur == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (cur.left == null && cur.right != null) {
            if (cur == root) {
                root = root.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else if (cur == parent.right) {
                parent.right = cur.right;
            }
        } else if (cur.left != null && cur.right == null) {
            if (cur == root) {
                root = root.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            }
        } else {
            TreeNode father = cur;
            TreeNode ghost = cur.left;
            while (ghost.right != null) {
                father = ghost;
                ghost = ghost.right;
            }
            cur.val = ghost.val;
            if (cur == father) {
                father.left = ghost.left;
            } else {
                father.right = ghost.left;
            }
        }
    }

    public static void main(String[] args) {
        二叉搜索树 x = new 二叉搜索树();
        x.insert(5);
        x.insert(6);
        x.insert(8);
        x.insert(3);
        x.insert(1);
        x.insert(2);
        x.print(x.root);
        x.delete(5);
        x.print(x.root);
    }

    private void print(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
}
