// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
import java.util.*;
public class GoodSplit {
    public int numSplits(String s) {
        if (s.length() == 1)
            return 0;
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        int ans = 0;
        map1.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++)
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
        if (map1.size() == map2.size())
            ans++;
        for (int split = 1; split <= s.length() - 2; split++) {
            map1.put(s.charAt(split), map1.getOrDefault(s.charAt(split), 0) + 1);
            map2.put(s.charAt(split), map2.getOrDefault(s.charAt(split), 0) - 1);
            if (map2.get(s.charAt(split)) == 0)
                map2.remove(s.charAt(split));
            if (map1.size() == map2.size())
                ans++;
        }
        return ans;
    }
}
