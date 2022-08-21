	class Solution {

    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] vis = new boolean[t.length];
        ArrayList<Integer> res = new ArrayList<>();
        int total = 0;
        while (total < t.length) {
            boolean flag = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (vis[i] == false && canReplace(i, s, t)) {
                    total += doReplace(i, s, t);
                    vis[i] = true;
                    flag = true;
                    res.add(i);

                    if (total == t.length) {
                        break;
                    }
                }
            }

            if (flag == false) {
                return new int[0];
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(res.size()-i-1);
        }

        return arr;
    }

    boolean canReplace(int index, char[] s, char[] t) {
        for (int i = 0; i < s.length; i++) {
            if (t[index + i] != '*' && s[i] != t[index + i]) {
                return false;
            }
        }
        return true;
    }

    int doReplace(int index, char[] s, char[] t) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (t[i + index] != '*') {
                t[i+index] = '*';
                count++;
            }
        }

        return count;
    }
}