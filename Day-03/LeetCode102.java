// -----------LeetCode 102 : Binary Tree Level Order Traversal------------

// We use queue for inorder traversal.....

import java.util.*;

public class LeetCode102 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<n; i++){
                TreeNode node = q.poll();

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }

                list.add(node.val);
            }

            result.add(list);
        }

        return result;
        
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }
}
