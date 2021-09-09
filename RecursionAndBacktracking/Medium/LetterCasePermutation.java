// https://leetcode.com/problems/letter-case-permutation/
import java.util.*;
public class LetterCasePermutation {
    List<String> ans =  new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        Func(s,"",0);
        return ans;
       
    }
    public void Func(String s, String full, int pos){
        if(s.length()==full.length()){
            ans.add(full);
            return;
        }
        char character = s.charAt(pos);
        int ascii = (int) character;
        if(ascii>=65 && ascii<=90){
            Func(s, full+character, pos+1);
            Func(s, full+Character.toLowerCase(character), pos+1);
            
        }
        else if(ascii>=97 && ascii<=122){
            Func(s, full+character, pos+1);
            Func(s, full+Character.toUpperCase(character), pos+1);
        }
        else{
              Func(s, full+character, pos+1);
        }
        
    }
}
