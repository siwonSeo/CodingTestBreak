class Solution {   
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1000000007;
        // Create tuples of engineer speed and efficiencies 
        int[][] engineerSpeedEff = new int[n][2];
        for (int i = 0; i < n; ++i) engineerSpeedEff[i] = new int[] {efficiency[i], speed[i]};
        
        // Sort the array by efficiency from highest to lowest. Ignore speed. 
        Arrays.sort(engineerSpeedEff, (a, b) -> b[0] - a[0]);
        
        // Create a Min Heap to track the current k team members I have selected. The top of the min
        // heap is the team member with the lowest speed.
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        
        long totalSpeedOfCurrentTeam = 0;
        long result = 0;
        
        for(int[] arr : engineerSpeedEff){
            // Add an engineer to the team. Recall this is being done in order of efficiency highest to lowest. 
            pq.add(arr[1]);
           
            // Change the total sum of the team after adding this engineer. 
            totalSpeedOfCurrentTeam = (totalSpeedOfCurrentTeam + arr[1]);
            
            // If we already have k people in our team then we have to remove someone. If we are removing someone
            // from the team for someone with a lower efficiency then it doesn't matter the efficiency of the person
            // we remove but rather the speed. Thus, we remove the teammate with the least speed in order to experiment
            // if this new candidate will have a better result on the team. 
            if(pq.size() > k){
                totalSpeedOfCurrentTeam -= pq.poll();
            }
            
            // Only persist the result if the new candidate we used to replace the old candiate is better than the last 
            // result. 
            result = Math.max(result, (totalSpeedOfCurrentTeam * arr[0]));
        }
        
        
        return (int) (result % (long)mod);
    }    
}