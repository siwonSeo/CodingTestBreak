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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean res = true;
        
        q.add(root);
        int odd = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean inc = odd % 2 == 0 ? true : false;
            int temp = inc ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                int val = node.val;
                
                if((val % 2  == 0) == inc) return false;
                
                if(inc){
                    if(val <= temp) return false;
                }else{
                    if(val >= temp) return false;
                }
                
                temp = val;
                
                if(node.left != null){
                    q.add(node.left);
                }
                
                if(node.right != null){
                    q.add(node.right);
                }
                
            }
            
            odd++;
        }
        
        return res;
    }
}