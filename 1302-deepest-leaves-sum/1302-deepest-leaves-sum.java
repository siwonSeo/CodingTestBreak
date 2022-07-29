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
    int deepestIndex = 0;
    Map<Integer,Integer> sumMap = new HashMap<>();
    public int deepestLeavesSum(TreeNode root) {
        goLeaf(root,0);
        return sumMap.get(deepestIndex);
    }
    
    public void goLeaf(TreeNode root,int deep){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            deepestIndex = Math.max(deepestIndex,deep);
            sumMap.put(deep, sumMap.getOrDefault(deep,0)+root.val);
        }
        
        if(root.left != null){
            goLeaf(root.left,deep+1);
        }
        
        if(root.right != null){
            goLeaf(root.right,deep+1);
        }        
    }
}