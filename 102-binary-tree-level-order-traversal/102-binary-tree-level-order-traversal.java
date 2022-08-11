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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        setNode(root,0);
        return res;
    }
    
    public void setNode(TreeNode root, int depth){
        if(root == null){
            return;
        }
        
        int value = root.val;
        if(depth < res.size()){
            res.get(depth).add(value);
        }else{
            res.add(new ArrayList<Integer>());
            res.get(depth).add(value);
        }
        
        setNode(root.left,depth+1);
        setNode(root.right,depth+1);
    }
}