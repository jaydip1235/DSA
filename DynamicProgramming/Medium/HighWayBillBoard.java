// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/highway-billboard-official/ojquestion
import java.util.*;
public class HighWayBillBoard {
     public static int solution(int m, int[] x, int[] rev, int t) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<x.length;i++) {
            map.put(x[i],rev[i]);
        }
        int dp[] = new int[m+1];
        dp[0]=0;
        for(int i=1;i<=m;i++){
            if(map.containsKey(i)== false){
                dp[i] = dp[i-1];
            }else{
                int taken =map.get(i);
                if(i>=t+1)taken+=dp[i-t-1];
                int not_taken = dp[i-1];
                dp[i] = Math.max(taken,not_taken);
            }
        }
        return dp[m];
    }
}
