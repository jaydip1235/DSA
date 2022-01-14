// https://leetcode.com/problems/valid-anagram/
import java.util.*;
public class ValidAnagram {
    public boolean isAnagram(String s1, String s2) {
        HashMap<Character,Integer>map = new HashMap<>();
		
		//populate this map using s1
		for(int i=0; i < s1.length();i++) {
		    char ch = s1.charAt(i);
		    int nf = map.getOrDefault(ch,0) + 1;
		    map.put(ch,nf);
		}
		
		//cancel out this map using s2
		for(int i=0; i < s2.length();i++) {
		    char ch = s2.charAt(i);
		    
		    if(map.containsKey(ch) == false) {
		        return false;
		    }
		    else {
		        if(map.get(ch) == 1) {
		            map.remove(ch);
		        }
		        else {
		            int nf = map.get(ch) - 1;
		            map.put(ch,nf);
		        }
		    }
		}

		
		return map.size() == 0;
    }
}
