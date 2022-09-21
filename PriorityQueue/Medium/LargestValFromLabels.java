// https://leetcode.com/problems/largest-values-from-labels/
import java.util.*;
public class LargestValFromLabels{
    class Solution {

        class Item {
            int value;
            int label;

            Item() {

            }

            Item(int value, int label) {
                this.value = value;
                this.label = label;
            }
        }

        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

            List<Item> items = new ArrayList<>();

            for (int i = 0; i < values.length; i++) {
                items.add(new Item(values[i], labels[i]));
            }

            PriorityQueue<Item> pq = new PriorityQueue<>((Item a, Item b) -> b.value - a.value);
            pq.addAll(items);
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            while (!pq.isEmpty() && numWanted > 0) {
                Item curr = pq.remove();
                map.put(curr.label, map.getOrDefault(curr.label, 0) + 1);
                if (map.get(curr.label) <= useLimit) {
                    ans += curr.value;
                    numWanted--;
                }
            }
            return ans;

        }
    }
}