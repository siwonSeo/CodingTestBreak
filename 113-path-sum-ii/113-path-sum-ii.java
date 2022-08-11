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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        setPath(root, 0, targetSum, new ArrayList<Integer>());
        return res;
    }
    
    public void setPath(TreeNode root, int currSum, int targetSum, List<Integer> pathList){
        if(root == null){
            if(currSum == targetSum){
                res.add(pathList);
            }
            return;
        }
        
        List<Integer> newPathList = new ArrayList<>(pathList);
        newPathList.add(root.val);
        currSum+=root.val;
        
        if(root.left == null && root.right == null && currSum == targetSum){
            res.add(newPathList);
            return;
        }
        
        

        
        if(root.left != null){
            setPath(root.left, currSum, targetSum, newPathList);
        }
        
        if(root.right != null){
            setPath(root.right, currSum, targetSum, newPathList);
        }        
    }
}