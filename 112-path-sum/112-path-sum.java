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
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        setIsPath(root,0,targetSum);
        return res;
    }
    
    public void setIsPath(TreeNode root, int currSum, int targetSum){
        if(root == null){
            if(currSum == targetSum){
                res = true;
            }
            return;
        }
        
        currSum += root.val;
        if(root.left == null && root.right == null && currSum == targetSum){
            res = true;
            return;
        }
        
        if(root.left != null){
            setIsPath(root.left, currSum, targetSum);
        }
        
        if(root.right != null){
            setIsPath(root.right, currSum, targetSum);
        }        
    }
}