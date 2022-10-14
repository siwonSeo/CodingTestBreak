class Solution {
    public int deleteAndEarn(int[] nums) {
        int length = nums.length;
        int[] count = new int[10001];
        for(int num : nums){
            count[num] += num;
        }
        
        int[] dp = new int[130003];
        for(int i = 10000; i>= 0; i--){
            dp[i] = Math.max(count[i]+dp[i+2],dp[i+1]);
        }
        return dp[0];
    }
}