class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i==0){
                sum[i] = nums[i];
                res = Math.max(res, sum[i]);
                continue;
            }
            if(sum[i-1] >= 0){
                sum[i] = nums[i] + sum[i-1];
            }else{
                sum[i] = nums[i];
            }
           
            res = Math.max(res, sum[i]);
           
        }
        return res;
    }
}