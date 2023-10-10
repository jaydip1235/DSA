public class MAxChunnkSortedTwo {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] rmin = new int[n + 1];
        rmin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rmin[i] = Math.min(arr[i], rmin[i + 1]);
        }
        int ans = 0, lmax = 0;
        for (int i = 0; i < n; i++) {
            lmax = Math.max(lmax, arr[i]);
            if (lmax <= rmin[i + 1]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MAxChunnkSortedTwo solution = new MAxChunnkSortedTwo();
        int[] arr = {2, 1, 3, 4, 4};
        int result = solution.maxChunksToSorted(arr);
        System.out.println("Maximum number of chunks: " + result);
    }
}
