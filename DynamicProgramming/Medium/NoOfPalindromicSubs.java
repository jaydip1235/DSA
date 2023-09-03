// https://leetcode.com/problems/palindromic-substrings/
public class NoOfPalindromicSubs{
       public int countSubstrings(String s) {
        int ans=0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();i++,j++){
                if(g==0){
                    dp[i][j] = true;
      
                }
                else if(g==1){
                    if(s.charAt(j)==s.charAt(i)){
                        dp[i][j] = true;
                    
                    }
                }
                else{
                    if(s.charAt(j)==s.charAt(i) && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                  if(dp[i][j]){
                    ans++;
                }
            }
        }
        return ans;

    }
}