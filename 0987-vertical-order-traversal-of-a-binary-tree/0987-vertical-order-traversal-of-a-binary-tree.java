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
    static class Pair {
        TreeNode node;
        int col;
        int row;
        Pair(TreeNode node , int col , int row){
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
   public List<List<Integer>> verticalTraversal(TreeNode root) {
        // code here
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
     
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 0 , 0));

        while(!q.isEmpty()){
            Pair current = q.poll();
            
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;
            
            // if(!map.containsKey(col)){
            //     map.put(col , new TreeMap<>());
            // }
            // if(!map.get(col).containsKey(row)){
            //     map.get(col).put(row , new PriorityQueue<>());
            // }
            map.putIfAbsent(col , new TreeMap<>());
            map.get(col).putIfAbsent(row , new PriorityQueue<>());

            map.get(col).get(row).add(node.val);
            
            if(node.left != null){
                q.add(new Pair(node.left , col - 1 ,row + 1 ));
            }
            if(node.right != null){
                q.add(new Pair(node.right , col + 1 , row + 1 ));
            }
        }
        for(TreeMap< Integer, PriorityQueue<Integer>> rows : map.values()){
            ArrayList<Integer> list = new ArrayList<>();
            
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}