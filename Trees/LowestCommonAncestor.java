public class LowestCommonAncestor {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(18);
        root.left.right.right = new TreeNode(19);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode LCA = findLCA(root, root.left.left, root.right.right);

        System.out.println(LCA != null ? LCA.val : null);
    }

    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null)
            return root;
        return left == null ? right : left;
    }
}
