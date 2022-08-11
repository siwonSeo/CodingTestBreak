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
    List<Integer> res = new ArrayList<>(); 
    public List<Integer> preorderTraversal(TreeNode root) {
        setData(root);
        return res;
        
    }
    
    public void setData(TreeNode root){
        if(root == null){
            return;
        }
        
        res.add(root.val);
        
        if(root.left != null){
            setData(root.left);
        }
        
        if(root.right != null){
            setData(root.right);
        }        
    }
}