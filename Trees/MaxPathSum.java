public class MaxPathSum {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(3);
        // root.right.left = new TreeNode(5);
        // root.right.right = new TreeNode(6);
        // root.right.left.left = new TreeNode(7);
        // root.right.left.right = new TreeNode(8);
        // root.right.right.left = new TreeNode(9);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(-25);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);

        findMaxPathSum(root);
        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;

    public static int findMaxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);

        int tempMax = Math.max(root.val, Math.max(left + root.val, right + root.val));
        max = Math.max(max, Math.max(tempMax, left + right + root.val));
        // System.out.println(max+" "+tempMax);
        return tempMax;
    }
}
