// https://www.lintcode.com/problem/903/
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for(int i=0;i<updates.length;i++){
            int s = updates[i][0];
            int e = updates[i][1];
            ans[s]+=updates[i][2];
            if(e+1<length)ans[e+1]-=updates[i][2];
        }
        for(int i=1;i<length;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}
