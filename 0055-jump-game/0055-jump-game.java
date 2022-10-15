class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        boolean res = true;
        int length = nums.length;

        int maxJump = 0;
  
        for(int i = 0; i < length - 1; i++){
            if(i>maxJump){
                return false;
            }
            int num = nums[i];
            maxJump = Math.max(maxJump, i+num);
        }
        
        return maxJump>=length-1;
        
    }
}