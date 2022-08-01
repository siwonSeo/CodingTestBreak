class Solution {
    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] posi = new int[length/2];
        int[] nega = new int[length/2];
        int p = 0;
        int n = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] > 0){
                posi[p++] = nums[i];                
            }else{
                nega[n++] = nums[i];
            }
        }
        
        for(int i = 0; i < length; i++){
            if(i%2 == 0){
                nums[i] = posi[i/2];
            }else{
                nums[i] = nega[i/2];
            }
        }
        
        return nums;
    }
}