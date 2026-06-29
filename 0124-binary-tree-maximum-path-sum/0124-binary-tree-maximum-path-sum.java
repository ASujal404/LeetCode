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

    int maxsum  = Integer.MIN_VALUE;

    private int helper(TreeNode root){
        if(root == null) return 0;

        int left_t = Math.max(0, helper(root.left));
        int right_t = Math.max(0 , helper(root.right));

        maxsum = Math.max(maxsum , left_t + right_t + root.val );

        return root.val + Math.max(left_t , right_t);
    }
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return maxsum;
    }
}