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
    public boolean findTarget(TreeNode root, int k) {        
        boolean res = false;        
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                int val = node.val;                
                if(set.contains(k-val)) return true;
                set.add(val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                
            }
        }
        
        return res;
        
    }
}