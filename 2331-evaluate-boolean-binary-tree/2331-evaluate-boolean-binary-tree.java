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
    public boolean evaluateTree(TreeNode root) {
        return calc(root) == 1;
    }
    
    public int calc(TreeNode root){
        int val = root.val;
        if(root.left != null && root.right != null){
            if(val == 2){
                return calc(root.left) | calc(root.right);        
            }
            
            if(val == 3){
                return calc(root.left) & calc(root.right);       
            }            
                
        }
        
        return val;
    }
}