class Solution {      
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] res = new int[length];
        char[] cArr = boxes.toCharArray();
        
        int[] left = new int[length];
        int[] right = new int[length];
        
        int count = cArr[0] - '0';
        for(int i = 1; i < length; i++){
            left[i] = left[i-1] + count;
            count+=cArr[i]-'0';
        }
        
        count = cArr[length-1] - '0';
        
        for(int i = length-2; i >=0; i--){
            right[i] = right[i+1] + count;
            count+=cArr[i]-'0';
        }
        
        for(int i = 0; i<length; i++){
            res[i] = left[i] + right[i];
        }
        
        return res;
    }
        
}