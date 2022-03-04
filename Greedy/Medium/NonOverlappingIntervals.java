// https://leetcode.com/problems/non-overlapping-intervals/
import java.util.*;
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int ans=0;
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=prevEnd){
                prevEnd = intervals[i][1];
            }
            else{
                ans+=1;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }
        }
        return ans;
    }
}
