class Solution {
    public boolean validUtf8(int[] data) {
        boolean res = true;
        int index = 0;
        int end = data.length -1;
        while(index <= end){
            int num = data[index];
            int digitCnt = getContinualOneCount(num);                    
        
            if(digitCnt == 0){                
                index++;
                continue;
            }
            if(digitCnt == 1 || digitCnt > 4) return false;
            int endCnt = index+digitCnt-1;
            if(endCnt > end) return false;

            while(++index <= endCnt){
                int dCnt =getContinualOneCount(data[index]);
                if(dCnt != 1){
                    return false;
                }
            }

        }
        return res;
    }
    
    public int getContinualOneCount(int num){
        int res = 0;  
        int divNum = 128;

        if(num < divNum){
            return 0;
        }        
        
        while(num > 0 && divNum > 2){
            int dNum = num / divNum;
            if(dNum == 0) break;
            num %=  divNum;
            divNum /= 2;
            res++;
        }       
        
        return res;
    }
}