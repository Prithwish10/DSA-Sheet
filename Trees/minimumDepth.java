public class minimumDepth {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(18);
        root.left.right.right = new TreeNode(19);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);

        int minDepth = findMinimumDepth1(root);
        System.out.print(minDepth);
    }
    static int min = Integer.MAX_VALUE;
    public static int findMinimumDepth(TreeNode root){
        if(root == null)
            return 0;
        findMinimumDepth(root, 0);
        return min;
    }

    public static void findMinimumDepth(TreeNode root, int counter) {
        if(root == null) {
            min = Math.min(min, counter);
            return;
        }
        counter += 1;
        findMinimumDepth(root.left, counter);
        findMinimumDepth(root.right, counter);

        counter -= 1;
    }

    public static int findMinimumDepth1(TreeNode root) {

        if(root == null)
            return 0;
        int left = findMinimumDepth1(root.left);
        int right = findMinimumDepth(root.right);

        return Math.min(left, right) + 1;
    }    
}
