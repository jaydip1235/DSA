// https://leetcode.com/problems/long-pressed-name/
import java.util.*;
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length()<name.length())return false;
        int i=0;
        int j=0;
        while(j<typed.length()){
            if(i<name.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if(j>0 && typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }
            else{
                return false;
            }
        }
        return name.length()==i;
        
    }
}
