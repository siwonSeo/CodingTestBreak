class Solution {
    Set<Integer> numList = new HashSet<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i <= 9; i++){
            setRes(n,k,new int[n],0,i);
        }
        int[] res = new int[numList.size()];
        int index = 0;
        for(int num : numList){
            res[index++] = num;
        }
        return res;
    }
    
    public void setRes(int n, int k, int[] intArr,int index, int startNum){
        if(index == intArr.length){
            return;
        }
        
        if(startNum < 0 || startNum > 9){
            return;
        }
        
        intArr[index] = startNum;
        
        if(index == intArr.length - 1){
            int resNum = 0;
            int mul = 1;
            for(int i = intArr.length - 1; i >= 0; i--){
                resNum += intArr[i] * mul;
                mul *= 10;
            }

            numList.add(resNum);
            return;
        }        
        
        setRes(n,k,intArr,index+1,startNum+k);
        setRes(n,k,intArr,index+1,startNum-k);
    }
    
}