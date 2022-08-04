class Solution {
    public int[] getConcatenation(int[] nums) {
        int numsLength = nums.length;
        int[] res = new int[numsLength*2];
        for(int i = 0; i < numsLength; i++){
            res[i] = nums[i];
            res[i+numsLength] = nums[i];
        }
        
        return res;
    }
}