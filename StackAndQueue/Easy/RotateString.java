// https://leetcode.com/problems/rotate-string/
import java.util.*;
public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length()!=goal.length())return false;
        String ans = s+s;
        if(ans.contains(goal))return true;
        return false;
    }
}
