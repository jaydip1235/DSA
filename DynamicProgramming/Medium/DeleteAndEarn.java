//https://leetcode.com/problems/delete-and-earn/
public class DeleteAndEarn{
    public int deleteAndEarn(int[] nums) {

        int inc = 0;
        int exc = 0;
        int hash[] = new int[100005];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }
        for (int i = 0; i < 100005; i++) {
            int in = i * hash[i] + exc;
            int ex = Math.max(inc, exc);
            exc = ex;
            inc = in;
        }
        return Math.max(exc, inc);
    }
}