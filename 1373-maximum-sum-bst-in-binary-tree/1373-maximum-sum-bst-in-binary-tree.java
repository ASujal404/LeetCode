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
    class NodeValue{
        int minValue , maxValue , sum;
        NodeValue(int minValue , int maxValue , int sum){
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.sum = sum;
        }
    }
     int ans = 0;
    private NodeValue helper(TreeNode root){
        if(root == null){
            return new NodeValue(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
          
          
        if(left.maxValue < root.val  && root.val < right.minValue){
           
           int currsum = left.sum + right.sum + root.val;
           ans = Math.max(ans , currsum);

           return new NodeValue(
                Math.min(root.val , left.minValue),
                Math.max(root.val , right.maxValue),
                currsum
           );
        }
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            0
        );
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
        
    }
}