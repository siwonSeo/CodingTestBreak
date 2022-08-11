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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return res;
        }
        setData(root, 0);
        return res;
    }
    
    public void setData(TreeNode root, int depth){
        if(root == null){
            return;
        }
        
        if(depth > res.size() - 1){
            res.add(root.val);
        }else{
            res.set(depth,root.val);
        }
        
        if(root.left != null){
            setData(root.left,depth+1);
        }
        

        
        if(root.right != null){
            setData(root.right,depth+1);
        }
    }
}