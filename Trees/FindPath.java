import java.util.LinkedList;

public class FindPath {
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
        int x=7;

        LinkedList<Integer> list = new LinkedList<>();
        printPath(root, x, list);
    }
    public static void printPath(TreeNode root, int x, LinkedList<Integer> list) {
        if(root == null)
            return;
        if(root.val == x){
            list.add(root.val);
            print(list);
        }
        
        list.add(root.val);
        //System.out.println(root.val+" "+list);
        printPath(root.left, x, list);
        printPath(root.right, x, list);
        list.removeLast();
    }

    public static void print(LinkedList<Integer> list){
        for(int l : list){
            System.out.print(l+" -> ");
        }
        System.out.print("null");
    }
}
