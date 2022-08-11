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
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        setDepth(root,0);
        return res;
    }
    
    public void setDepth(TreeNode root, int depth){       
        if(root == null){
            res = Math.min(res,depth);
            return;
        }       
        
        if((root.left == null && root.right == null)){
            res = Math.min(res,depth+1);
            return;
        }                
        
        if(root.left != null){
            setDepth(root.left, depth+1);    
        }
        
        if(root.right != null){
            setDepth(root.right, depth+1);    
        }

    }
}