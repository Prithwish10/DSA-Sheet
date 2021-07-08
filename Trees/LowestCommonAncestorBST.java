public class LowestCommonAncestorBST {

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

        TreeNode LCA = findLCA(root, root.left.right.left, root.left);

        System.out.println(LCA != null ? LCA.val : null);
    }

    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val > p.val && root.val > q.val)
            return findLCA(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return findLCA(root.right, p, q);
        else
            return root;
    }
}
