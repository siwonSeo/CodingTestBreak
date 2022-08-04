class Solution {
    public int[] buildArray(int[] nums) {
        int numsLength = nums.length;
        int[] res = new int[numsLength];
        for(int i = 0; i < numsLength; i++){
            res[i] = nums[nums[i]];
        }
        return res;
        
    }
}