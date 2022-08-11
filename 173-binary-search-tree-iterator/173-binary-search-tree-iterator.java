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
class BSTIterator {
    Queue<Integer> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        setData(root);
    }
    
    public int next() {
        if(queue.isEmpty()) return -1;
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    private void setData(TreeNode root){
        if(root == null){
            return;
        }
        
        setData(root.left);
        
        queue.offer(root.val);
        
        setData(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */