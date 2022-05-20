// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
public class MinTriangulationScore {
    public int minScoreTriangulation(int[] arr) {
        int dp[][] = new int[arr.length][arr.length];

        for(int g=0;g<arr.length;g++){
            for(int i=0,j=g;j<dp[0].length;i++,j++){
                if(g==1 || g==0)dp[i][j]=0;
                else if(g==2)dp[i][j]=arr[i]* arr[i+1]*arr[i+2];
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k=i+1;k<=j-1;k++){
                        int pre = arr[i]*arr[j]*arr[k];
                        int lp = dp[i][k];
                        int rp = dp[k][j];
                        int val = pre+lp+rp;
                        if(val<min){min=val;}
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][dp.length-1];
    }
}
