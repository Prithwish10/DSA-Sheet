public class Diameter {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        findDiameter(root);
        System.out.println(diameter);
    }

    static int diameter = 0;

    public static int findDiameter(TreeNode root) {
        if (root == null)
            return 0;

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);

        diameter = Math.max(diameter, 1 + left + right);

        return 1 + Math.max(left, right);
    }
}
