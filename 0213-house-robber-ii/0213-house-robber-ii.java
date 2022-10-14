class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int[] dp2 = new int[length+1];

        if(length == 0) return 0;
        if(length == 1) return nums[0];
        if(length == 2) return Math.max(nums[0],nums[1]);
        if(length == 3) {
            int max = 0;
            for(int num : nums){
                max = Math.max(num,max);
            }
            return max;
        }
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
           
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        
        for(int i = 2; i < length-1; i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        
        for(int i = 3; i < length; i++){
            dp2[i] = Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }
        
        return Math.max(dp[length-2],dp2[length-1]);
    }
}