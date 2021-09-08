// https://leetcode.com/problems/path-crossing/
import java.util.*;
public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<String> s = new HashSet<>();
        int x=0,y=0;
        s.add(x+"%"+y);
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='N')y++;
            if(path.charAt(i)=='S')y--;
            if(path.charAt(i)=='E')x++;
            if(path.charAt(i)=='W')x--;
            if(s.contains(x+"%"+y))return true;
            s.add(x+"%"+y);
        }
        
        return false;
    }
}
