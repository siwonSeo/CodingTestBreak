class Solution {
    class NumInfo{
        int num;
        int count;
        NumInfo(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    public int minSetSize(int[] arr) {
        Map<Integer,NumInfo> map = new HashMap<>();
        int res = 0;
        int arrLength = arr.length;
        int removeLength = 0;
        for(int num : arr){
            if(map.containsKey(num)){
                map.get(num).count++;
            }else{
                map.put(num,new NumInfo(num,1));
            }            
        }
        
        PriorityQueue<NumInfo> pr = new PriorityQueue<>((a,b)->b.count-a.count);
        for(Map.Entry<Integer,NumInfo> entry : map.entrySet()){
            pr.add(entry.getValue());
        }
        
        while(removeLength < arrLength / 2){
            removeLength += pr.poll().count;
            res++;
        }
        
        return res;
    }
}