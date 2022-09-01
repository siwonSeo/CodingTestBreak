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
    /*
    int res = 1;    
    public int goodNodes(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        setRes(root,pq);
        return res;
    }
    
    public void setRes(TreeNode node, PriorityQueue<Integer> pq){
        if(node == null){
            return;
        }
        
        if(!pq.isEmpty() && node.val >= pq.peek()){
            res++;
        }
        pq.add(node.val);
        setRes(node.left,pq);
        setRes(node.right,pq);
        pq.remove(node.val);
    }
    */
    
    int res = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        setRes(root,root.val);
        return res;
    }
    
    public void setRes(TreeNode node,int max){
        if(node == null){
            return;
        }
        
        if(node.val >= max){
            max = node.val;
            res++;
        }       
        
        setRes(node.left,max);
        setRes(node.right,max);

    }    
}