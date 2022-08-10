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
   
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortBST(nums,0,nums.length-1);
    }

    public TreeNode sortBST(int[] nums, int start,int end){      
        
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if(start < mid){
	        node.left = sortBST(nums,start,mid-1);
        }
                                      
        if(end > mid){
            node.right = sortBST(nums,mid+1,end);
        }
        return node;
    }    
}