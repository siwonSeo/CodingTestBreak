class Solution {
    public int deleteAndEarn(int[] nums) {
        int length = nums.length;
        int[] count = new int[10001];
        int maxNum = 0;
        for(int num : nums){
            count[num] += num;
            maxNum = Math.max(maxNum,num);
        }
        
        int[] dp = new int[maxNum+3];
        for(int i = maxNum; i>= 0; i--){
            dp[i] = Math.max(count[i]+dp[i+2],dp[i+1]);
        }
        return dp[0];
    }
}