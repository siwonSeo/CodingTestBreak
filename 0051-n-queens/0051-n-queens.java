class Solution {
    List<List<String>> resList = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] grid = new int[n][n];
        Set<Integer> ySet = new HashSet<>();
        Set<Integer> xSet = new HashSet<>();
        setRes(grid,ySet,xSet,0,n);
        return resList;
    }
    
    public void setRes(int[][] grid, Set<Integer> ySet, Set<Integer> xSet, int cnt, int n){
        if(cnt == n){
            setResList(grid);
            return;
        }        
        
        for(int i = 0; i < n; i++){
            int y = cnt;
            int x = i;
            if(ySet.contains(y) || xSet.contains(x)) continue;
            if(!getValidLoc(grid,y,x,ySet,xSet,n)) continue;
            grid[y][x] = 1;
            ySet.add(y);
            xSet.add(x);
            setRes(grid,ySet,xSet,cnt+1,n);
            grid[y][x] = 0;
            ySet.remove(y);
            xSet.remove(x);            
        }
    }
    
    public boolean getValidLoc(int[][] grid, int y, int x,Set<Integer> ySet, Set<Integer> xSet,int n){
        boolean res = true;
        int cpY = y;
        int cpX = x;
        while(--cpY >= 0 && --cpX >= 0){
            //if(ySet.contains(cpY) || xSet.contains(cpX)) return false;
            if(grid[cpY][cpX] == 1) return false;
        }
        cpY = y;
        cpX = x;
        while(++cpY < n && ++cpX < n){
            //if(ySet.contains(cpY) || xSet.contains(cpX)) return false;
            if(grid[cpY][cpX] == 1) return false;
        }        
        cpY = y;
        cpX = x;
        while(--cpY >= 0 && ++cpX < n){
            //if(ySet.contains(cpY) || xSet.contains(cpX)) return false;
            if(grid[cpY][cpX] == 1) return false;
        }       
        cpY = y;
        cpX = x;
        while(++cpY < n && --cpX >= 0){
            //if(ySet.contains(cpY) || xSet.contains(cpX)) return false;
            if(grid[cpY][cpX] == 1) return false;
        }                
        return res;
    }
    
    public void setResList(int[][] grid){
        List<String> list = new ArrayList<>();
        for(int[] xInfo : grid){            
            char[] cArr = new char[xInfo.length];
            for(int i = 0; i < xInfo.length; i++){
                int a = xInfo[i];
                if(a==0){
                    cArr[i] = '.';
                }else{
                    cArr[i] = 'Q';
                }
            }
            list.add(new String(cArr));
        }
        resList.add(list);
    }
}