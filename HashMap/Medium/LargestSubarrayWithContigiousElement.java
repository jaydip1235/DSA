// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/largest-subarray-with-contiguous-elements-official/ojquestion
import java.util.*;
public class LargestSubarrayWithContigiousElement{
    public static int solution(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int max = arr[i];
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(arr[j])) {
					break;
				}
				set.add(arr[j]);
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
				if (max - min == j - i) {
					ans = Math.max(ans, j - i + 1);
				}
			}
		}

		return ans;
	}
}