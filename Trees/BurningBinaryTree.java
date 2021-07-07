// Given a binary tree and target node. By giving the fire to the target node and fire starts to spread in a complete tree. The task is to print the sequence of the burning nodes of a binary tree.
// Rules for burning the nodes : 

// Fire will spread constantly to the connected nodes only.
// Every node takes the same time to burn.
// A node burns only once.

import java.util.LinkedList;
import java.util.Queue;

class BurningBinaryTree {

    static Queue<TreeNode> queue = new LinkedList<>();
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        printBurningTree(root, 5);
        printRest();
    }
    public static int printBurningTree(TreeNode root, int req_node) {
        if(root == null)
            return 0;
        if(root.val == req_node){
            System.out.println(root.val);
            if(root.left != null)
                queue.add(root.left);
            if(root.right != null)
                queue.add(root.right);
            return 1;
        }
        int left = printBurningTree(root.left, req_node);

        if(left == 1) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val+" ");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            System.out.println(root.val+" ");
            if(root.right != null)
                queue.add(root.right);
        }

        int right = printBurningTree(root.right, req_node);

        if(right == 1) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val+" ");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            System.out.println(root.val+" ");
            if(root.left != null)
                queue.add(root.left);
        }
        return left == 1 ? left : right;
    }

    public static void printRest() {

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val+" ");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            System.out.println();
        }
    }
}