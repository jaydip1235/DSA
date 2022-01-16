// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/group-shifted-string-official/ojquestion
import java.util.*;
public class GroupShiftedString {
    public static ArrayList < ArrayList < String >> groupShiftedStrings(String[] strings) {
        HashMap < String, ArrayList < String >> map = new HashMap < > ();

        for (String str: strings) {

            String key = getKey(str);

            if (map.containsKey(key) == true) {
                ArrayList < String > list = map.get(key);
                list.add(str);
            } 
            else {
                ArrayList < String > list = new ArrayList < > ();
                list.add(str);
                map.put(key, list);
            }
        }

        ArrayList < ArrayList < String >> ans = new ArrayList < > ();

        for (String key: map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }

    public static String getKey(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 1; i < str.length(); i++) {
            int gap = str.charAt(i) - str.charAt(i - 1);

            if (gap < 0) {
                gap += 26;
            }

            sb.append(gap + "#");
        }

        return sb.toString();
    } 
}
