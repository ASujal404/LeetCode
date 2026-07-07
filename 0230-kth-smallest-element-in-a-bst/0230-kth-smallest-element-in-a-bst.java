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
        int smallC = 0;
        int smallA = -1;
        int k ;
    private void inorder(TreeNode root ){
        if(root == null ) {
            return;
        }
        inorder(root.left);
        smallC++;
        if(smallC == k){
            smallA = root.val;
            return;
        }
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return smallA;
    }
}