class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cArr = s.toCharArray();
        int res = 0;
        for(int i = 0; i < cArr.length; i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < cArr.length; j++){
                char c = cArr[j];
                if(set.contains(c)) break;
                set.add(c);
            }
            res = Integer.max(res,set.size());
        }
        return res;
    }

}
