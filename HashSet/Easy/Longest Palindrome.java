// https://leetcode.com/problems/longest-palindrome/

class Solution {
    public int longestPalindrome(String s) {
        
      if(s==null || s.length()==0){
          return 0;
      }
      
        HashSet<Character> hs = new HashSet<>();
        
        int count =0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){ // if hash contains already that value.
                hs.remove(s.charAt(i));   // remove it from hash.
                count++;                    // increase the count.
            }else{
                hs.add(s.charAt(i));        // not present then add it.
            }
        }
        if(!hs.isEmpty()){                  // if not empty;
            return count *2+1; // odd   c c d count 3 *2 +1 = 7
        }
        return count*2; // even 
    }
}
​