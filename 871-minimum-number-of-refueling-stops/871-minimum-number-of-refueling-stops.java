class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
    int maxReach=startFuel;
    PriorityQueue<int[]> pq =new PriorityQueue<>((a,b) -> b[1]-a[1]);
    int count=0;
    int index=0;

    while(maxReach<target){
        while(index<stations.length && stations[index][0]<=maxReach){
            
            //store fuel in pq
            pq.add(stations[index]);
            index++;
        }
        
        if(pq.isEmpty())  
            return -1;
        
        maxReach +=pq.remove()[1];  //add top fuel value & remove if from pq
        count++;
        
    }
    return count;
}
}