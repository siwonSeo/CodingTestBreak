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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<List<Integer>> res2 = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root == null) return res2;
        while(!q.isEmpty()){            
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }     
            
            res.add(list);            
        }
        
        for(int i = res.size()-1; i>=0; i--){
            res2.add(res.get(i));
        }
        
        return res2;
    }
}