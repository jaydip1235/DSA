// https://leetcode.com/problems/find-center-of-star-graph/
import java.util.*;
public class FindCenter{
    public int findCenter(int[][] edges) {
        int freq[] = new int[100001];
        for(int i=0;i<2;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            freq[x]++;
            freq[y]++;
        }
        for(int i=0;i<100001;i++){
            if(freq[i]==2)return i;
        }
        return 0;
    }
}