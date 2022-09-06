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
    public TreeNode pruneTree(TreeNode root) {
        return convertTree(root);
    }
    
    public TreeNode convertTree(TreeNode root){
        if(root == null){
            return root;
        }   
        
        if(root.left != null) root.left = convertTree(root.left);
        if(root.right != null) root.right = convertTree(root.right);
        
        if(root.left == null && root.right== null){
            if(root.val == 0){
                return null;
            }else{
                return root;
            }
        }
        
        return root;
    }
}