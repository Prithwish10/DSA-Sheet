class InOrderPredecessorBST {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode res = findInorderPredecessor(root, root.left.right.left);
       
        System.out.println(res == null ? "No Successor present" : res.val);
    }

    public static TreeNode findInorderPredecessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
            return null;
        TreeNode node = search(root, p);
        if(node == null)
            return null;
        if(node.left != null) {
            TreeNode temp = node.left;
            while(temp.right != null)
                temp = temp.right;
            return temp;
        }
        else {
            TreeNode current = root;
            TreeNode ancestor = null;

            while(current != p) {
                if(p.val > current.val) {
                    ancestor = current;
                    current = current.right;
                }
                else if(p.val < current.val) {
                    current = current.left;
                }
            }
            return ancestor;
        }
    }

    public static TreeNode search(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        if(root.val == p.val)
            return root;
        if(root.val > p.val)
            return search(root.left, p);
        else
            return search(root.right, p);
    }
}