class Solution {
    public String convertToTitle(int columnNumber) {
        final int mod = 26;
        
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){           
            int num = columnNumber % mod;
            if(num == 0) num = mod;
            columnNumber -= num;
            columnNumber /= mod;
            if(num > 0){
                char c = (char)('A' + num - 1);
                sb.append(c);                
            }

        }
        return sb.reverse().toString();
    }
}