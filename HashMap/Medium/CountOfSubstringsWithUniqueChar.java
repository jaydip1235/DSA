// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-all-unique-characters-official/ojquestion
import java.util.*;
public class CountOfSubstringsWithUniqueChar {
    public static int solution(String str) {
        // write your code here

        HashMap < Character, Integer > map = new HashMap < > ();

        int i = -1;
        int j = -1;
        int count = 0;

        while (i < str.length() - 1) {
            //aquire
            while (i < str.length() - 1) {
                i++;

                char ch = str.charAt(i);
                int of = map.getOrDefault(ch, 0);
                map.put(ch, of +1);

                if (map.get(ch) > 1) {
                    break;
                } 
                else {
                    count += (i - j);
                }
            }

            //release
            while (j < i) {
                j++;

                char ch = str.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);
                } 
                else {
                    int of = map.get(ch);
                    map.put(ch, of -1);
                    count += (i - j);
                    break;
                }
            }
        }

        return count;
    }
}
