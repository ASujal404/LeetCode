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
    int index =0;
    public TreeNode bstFromPreorder(int[] preorder) {

        return helper(preorder , Integer.MAX_VALUE);        
    }
    private TreeNode helper(int[] preorder , int bound){

        // base case 
        if(index == preorder.length || preorder[index] > bound){
            return null;
        }

        //Current node 
        TreeNode root = new TreeNode(preorder[index++]);

        //leftsubtree
        root.left = helper(preorder , root.val);

        //rightsubtree
        root.right = helper(preorder , bound);

        return root;
    }
}