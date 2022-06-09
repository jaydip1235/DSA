// https://leetcode.com/problems/frog-jump/
public class FrogJump {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(stones[0]).add(1);
        for (int i = 0; i < stones.length; i++) {
            HashSet<Integer> jumps = map.get(stones[i]);
            for (int j : jumps) {
                int news = j + stones[i];
                if (news == stones[stones.length - 1])
                    return true;
                if (map.containsKey(news) == true) {
                    map.get(news).add(j);
                    map.get(news).add(j + 1);
                    if (j - 1 > 0)
                        map.get(news).add(j - 1);
                }
            }
        }
        return false;
    }
}
