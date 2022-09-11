class Solution {   
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1000000007;
        int[][] engineerSpeedEff = new int[n][2];
        for (int i = 0; i < n; ++i) engineerSpeedEff[i] = new int[] {efficiency[i], speed[i]};

        Arrays.sort(engineerSpeedEff, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        long totalSpeedOfCurrentTeam = 0;
        long result = 0;
        
        for(int[] arr : engineerSpeedEff){
            pq.add(arr[1]);
           
            totalSpeedOfCurrentTeam = (totalSpeedOfCurrentTeam + arr[1]);
            if(pq.size() > k){
                totalSpeedOfCurrentTeam -= pq.poll();
            }
            
            result = Math.max(result, (totalSpeedOfCurrentTeam * arr[0]));
        }
        
        
        return (int) (result % (long)mod);
    }    
}