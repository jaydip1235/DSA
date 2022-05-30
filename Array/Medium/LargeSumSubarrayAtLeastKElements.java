// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/maximum-sum-subarray-with-at-least-k-elements-official/ojquestion
public class LargeSumSubarrayAtLeastKElements{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

    public static int solution(int[] arr, int k) {
        int[] maxSum = new int[arr.length];
        // use kadane's
        maxSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum[i] = Math.max(arr[i], maxSum[i - 1] + arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int ans = sum;
        ;
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
            ans = Math.max(ans, sum + maxSum[i - k]);
        }

        return ans;
    }
}