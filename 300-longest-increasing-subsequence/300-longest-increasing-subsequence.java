class Solution {
    public int lengthOfLIS(int[] nums) {
    	int res = 0;
    	int numsLength = nums.length;
    	int[] rankArr = new int[numsLength];
    	for(int i = 0; i <nums.length; i++) {
    		int iVal = nums[i];
    		for(int j = i+1; j <nums.length; j++) {
    			int jVal = nums[j];
    			if(jVal > iVal) {
//    				rankArr[j] = rankArr[i]+1;
    				rankArr[j] = Math.max(rankArr[j], rankArr[i]+1);
    			}
    		}
    	}
    	
    	for(int i = 0; i <nums.length; i++) {
    		res = Math.max(res, rankArr[i]);
    	}
    	
    	return res+1;
        
    }

   
}