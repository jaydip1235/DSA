// https://leetcode.com/problems/longest-palindromic-substring/
public class LonPalSubstring {
    public String longestPalindrome(String s) {
        int len = 0;
        int si = 0, ei = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;

                } else if (g == 1) {
                    if (s.charAt(j) == s.charAt(i)) {
                        dp[i][j] = true;

                    }
                } else {
                    if (s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && g + 1 > len) {
                    si = i;
                    ei = j;
                    len = g + 1;
                }
            }
        }
        return s.substring(si, ei + 1);
    }
}
