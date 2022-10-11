class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        boolean res = false;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num <= min1){
                min1 = num;
            }else if(num <= min2){
                min2 = num;
            }else if(num > min1 && num > min2){
                return true;
            }
        }
        
        return res;
    }
}