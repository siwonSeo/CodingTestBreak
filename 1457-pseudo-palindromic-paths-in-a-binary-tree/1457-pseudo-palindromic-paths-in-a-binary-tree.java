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
    int res = 0;  
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        
        //map.put(root.val,1);
        int[] arr = new int[9];
        setRes(root,arr, 1);
        return res;
    }
    
    public void setRes(TreeNode root, int[] arr, int n){       
        if(root == null){
            return;
        }

        int num = root.val;
        arr[num-1]++;
        
        if(root.left == null && root.right == null){            
            if(getPseudoPalindromic(arr,n)){
                res++;
            }
            
            arr[num-1]--;
            return;
        }                
        
        if(root.left != null) setRes(root.left,arr,n+1);
        if(root.right != null) setRes(root.right,arr,n+1);
        arr[num-1]--;        
        
    }
    
    public boolean getPseudoPalindromic(int[] arr, int n){
        int oddCnt = 0;
        int validCnt = n % 2;
        boolean res = true;
        for(int val : arr){            
            oddCnt += val % 2;
            if(oddCnt > validCnt) return false;            
        }
        
        if(oddCnt != validCnt) return false;
        
        return res;
    }    
}