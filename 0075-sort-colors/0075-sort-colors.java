class Solution {
    public void sortColors(int[] nums) {
        int[] numInfo = new int[3];
        
        for(int i = 0; i < nums.length; i++){
            numInfo[nums[i]]++;
        }
        
        int indexStart = 0;
        for(int i = 0; i < numInfo.length; i++){
            int cnt = numInfo[i];            
            for(int j = 0; j < cnt; j++){
                nums[j+indexStart] = i;
            }
            indexStart += cnt;
        }
    }
}