import java.util.Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            lmax[i] = maxi;
            maxi = Math.max(maxi, height[i]);
        }

        maxi = 0;
        for (int i = n - 1; i >= 0; i--) {
            rmax[i] = maxi;
            maxi = Math.max(maxi, height[i]);
        }

        for (int i = 0; i < n; i++) {
            if (Math.min(lmax[i], rmax[i]) - height[i] > 0) {
                ans += Math.min(lmax[i], rmax[i]) - height[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solution.trap(height);
        System.out.println("Trapped Rainwater: " + result);
    }
}
