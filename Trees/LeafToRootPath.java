public class LeafToRootPath {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int x=8;

        
        printPath(root, x);
    }
    public static int printPath(TreeNode root, int x) {
        if(root == null)
            return 0;
        if(root.val == x){
            System.out.print(root.val+" ");
            return 1;
        }
        int left = printPath(root.left, x);
        int right = printPath(root.right, x);

        if(left == 1)
            System.out.print(root.val+" ");
        if(right == 1)
            System.out.print(root.val+" ");
        return left == 1 ? left : right;
    }
}
