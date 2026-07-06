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
    private TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if(root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left , key);
        }else if(key > root.val){
            root.right = deleteNode(root.right , key);
        }else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode sucessor = findMin(root.right);
            root.val = sucessor.val;
            root.right = deleteNode(root.right , sucessor.val);
        }
        return root;
    }
}