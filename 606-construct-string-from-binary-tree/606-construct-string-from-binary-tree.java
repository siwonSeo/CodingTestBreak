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
    public String tree2str(TreeNode root) {
        return getTreeStr(root);
    }
    
    public String getTreeStr(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){           
            return "";
        }
        
        String str = String.valueOf(root.val);
        
       
        sb.append(str);
        
        if(root.left == null && root.right == null){
            return sb.toString();
        }
        
        sb.append(String.format("(%s)",getTreeStr(root.left)));
        if(root.right != null)sb.append(String.format("(%s)",getTreeStr(root.right)));
        
        return sb.toString();
    }
}