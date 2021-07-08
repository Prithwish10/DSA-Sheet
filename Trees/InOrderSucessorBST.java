public class InOrderSucessorBST {
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

        TreeNode res = findInorderSucessor(root, root.right.left);
       
        System.out.println(res == null ? "No Successor present" : res.val);
    }
    public static TreeNode findInorderSucessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        TreeNode node = search(root, p);
        
        if(node == null)
            return null;
        if(node.right != null) {
            TreeNode temp = node.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        else {
            TreeNode current = root;
            TreeNode ancestor = null;

            while(current != p) {
                if(p.val < current.val) {
                    ancestor = current;
                    current = current.left;
                }
                else if(p.val > current.val) {
                    current = current.right;
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
