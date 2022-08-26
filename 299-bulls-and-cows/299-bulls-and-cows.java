class Solution {
    public String getHint(String secret, String guess) {
        
        int numLength = secret.length();
        int bullCnt = 0;
        int cowCnt = 0;
        char[] secretArr = secret.toCharArray();        
        char[] guessArr = guess.toCharArray();
        int[] secretCntArr = new int[10];
        int[] guessCntArr = new int[10];
        
        List<Character> secretList = new ArrayList<>();
        List<Character> guessList = new ArrayList<>();
        
        for(int i = 0; i < numLength; i++){
            char c = secretArr[i];
            if(c == guessArr[i]){
                bullCnt++;
            }else{
                secretList.add(c);
                guessList.add(guessArr[i]);
            }
        }
        
        int otherLength = secretList.size();
        
        for(int i = 0; i < otherLength; i++){
            secretCntArr[secretList.get(i)-'0']++;
            guessCntArr[guessList.get(i)-'0']++;
        }
        
        for(int i = 0; i < secretCntArr.length; i++){
            cowCnt += Math.min(secretCntArr[i],guessCntArr[i]);
        }

        
        return (bullCnt+"A"+cowCnt+"B");
    }
}