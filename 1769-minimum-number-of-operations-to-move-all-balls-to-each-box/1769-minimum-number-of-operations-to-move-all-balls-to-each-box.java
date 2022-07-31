class Solution {      
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] res = new int[length];
        char[] cArr = boxes.toCharArray();
        
        for(int i = 0; i<length; i++){
            for(int j = 0; j <i; j++){
            	char c = cArr[j];
                res[i] += (i-j) * (c-'0');
            }
            
            for(int j = i+1; j < length; j++){         
            	char c = cArr[j];
                res[i] += (j-i) * (c-'0');
            }            
        }
        
        return res;
    }
        
}