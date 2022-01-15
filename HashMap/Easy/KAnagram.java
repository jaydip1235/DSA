// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/k-anagrams-official/ojquestion
import java.util.*;
public class KAnagram {
    public static boolean areKAnagrams(String str1, String str2, int k) {
		
		HashMap<Character,Integer>map = new HashMap<>();
		
		for(char ch : str1.toCharArray()) {
		    
		    int nf = map.getOrDefault(ch,0) + 1;
		    map.put(ch,nf);
		}
		
		for(char ch : str2.toCharArray()) {
		    
		    int nf = map.getOrDefault(ch,0) - 1;
		    map.put(ch,nf);
		}
		
		
		int ro = 0; //required operations
		for(char key : map.keySet()) {
		    int val = map.get(key);
		    
		    if(val > 0) {
		        ro += val;
		    }
		}
		
		return ro <= k;
		
	}
}
