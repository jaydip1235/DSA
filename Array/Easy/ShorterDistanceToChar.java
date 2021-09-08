// https://leetcode.com/problems/shortest-distance-to-a-character/
import java.util.* ;
public class ShorterDistanceToChar {
    public int[] shortestToChar(String s, char c) {
        int ans[] = new int[s.length()];
        int pos = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                ans[i]=0;
                pos=i;
            }
            else {
                ans[i]=Math.abs(i-pos);
                
        }
        }
        pos = Integer.MAX_VALUE;  
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==c){
                pos=i;
            }
            else{
                ans[i]=Math.min(ans[i],Math.abs(i-pos));
            }
        }
            return ans;
    }
}
