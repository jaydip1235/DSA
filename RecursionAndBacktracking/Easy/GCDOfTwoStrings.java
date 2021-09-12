// https://leetcode.com/problems/greatest-common-divisor-of-strings/
import java.util.* ;
public class GCDOfTwoStrings {
    public String gcdOfStrings(String s1, String s2) {
        if(!(s1+s2).equals(s2+s1))return "";
        if(s1.equals(s2))return s1;
        if(s1.length()>s2.length()){
            return  gcdOfStrings(s1.substring(s2.length()),s2);
        }
         return  gcdOfStrings(s1,s2.substring(s1.length()));
    }
}
