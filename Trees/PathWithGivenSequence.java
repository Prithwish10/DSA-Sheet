class PathWithGivenSequence {
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

        int ar[] = {1, 2, 5, 19, 2, 3, 5};
        boolean isSequencePresent = isSequencePresent(root, ar, 0);
        System.out.print(isSequencePresent);
    }

    public static boolean isSequencePresent(TreeNode root, int ar[], int i) {

        if(root == null)
            return ar.length == 0;
        if(i >= ar.length || root.val != ar[i])
            return false;
        if(ar[i] == root.val && root.left == null && root.left == null){
            System.out.println(root.val +" " + ar[i]);
            return true;
        }
        
        boolean left = isSequencePresent(root.left, ar, i + 1);
        boolean right = isSequencePresent(root.right, ar, i + 1);

        return left || right;
    }
}