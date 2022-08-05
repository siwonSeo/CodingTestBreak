class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memory = new Integer[target + 1];
        return recurse(nums, target, memory);
    }
    
    public int recurse(int[] nums, int remain, Integer[] memory){
        if(remain < 0) return 0;
        if(memory[remain] != null) return memory[remain];
        if(remain == 0) return 1;
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += recurse(nums,remain - nums[i], memory);
        }
        
        memory[remain] = ans;
        return memory[remain];
    }
}