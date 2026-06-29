/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter = 0;
    private int height(TreeNode root){
        if(root == null) return 0;

        int left_h = height(root.left);
        int right_h = height(root.right);

        diameter = Math.max(diameter , left_h + right_h);

        return 1 + Math.max(left_h , right_h);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);

        return diameter;
    }
}