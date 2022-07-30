class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int plantsLength = plants.length;
        int currPlant = 0;
        boolean refillYn = false;
        int remainWater = capacity;
        while(currPlant<plantsLength){
            int plant = plants[currPlant];
            if(remainWater >= plant){
                currPlant++;
                remainWater -= plant;
                if(refillYn){
                    refillYn = false;
                    res += currPlant;
                }else{
                    res++;    
                }
                
            }else{
                refillYn = true;
                remainWater = capacity;
                res += currPlant;
            }
        }
        return res;
    }
}