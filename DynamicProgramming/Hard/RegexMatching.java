// https://leetcode.com/problems/regular-expression-matching/
public class RegexMatching{
    public boolean isMatch(String s, String p) {

        boolean dp[][] = new boolean[p.length() + 1][s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    char ch = p.charAt(i - 1);
                    dp[i][j] = ch == '*' ? dp[i - 2][j] : false;
                } else {
                    char schar = s.charAt(j - 1);
                    char pchar = p.charAt(i - 1);
                    if (pchar == '*') {
                        dp[i][j] = dp[i - 2][j];
                        char ppchar = p.charAt(i - 2);
                        if (ppchar == schar || ppchar == '.') {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                        }
                    } else if (pchar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pchar == schar) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }

                }
            }
        }
        return dp[p.length()][s.length()];
    }
}