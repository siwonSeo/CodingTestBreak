class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i = 1; i < length; i++){
            int num = nums[i];
            int temp = min;
            min = Math.min(num,Math.min(num*max,num*min));
            max = Math.max(num,Math.max(num*max,num*temp));
            
            if(max > res){
                res = max;
            }
        }
        
        return res;
    }
}