// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-anagram-mappings-official/ojquestion
import java.util.*;
public class AnagramMapping {
    public static int[] anagramMappings(int[] A, int[] B) {
        HashMap < Integer, ArrayList < Integer >> map = new HashMap < > ();

        for (int i = B.length - 1; i >= 0; i--) {
            int ele = B[i];

            if (map.containsKey(ele) == false) {
                ArrayList < Integer > list = new ArrayList < > ();
                list.add(i);
                map.put(ele, list);
            } else {
                ArrayList < Integer > list = map.get(ele);
                list.add(i);
            }
        }


        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            ArrayList < Integer > list = map.get(A[i]);
            int occ = list.remove(list.size() - 1);

            ans[i] = occ;
        }

        return ans;
    }
}
