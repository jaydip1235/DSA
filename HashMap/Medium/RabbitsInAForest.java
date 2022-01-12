// https://leetcode.com/problems/rabbits-in-forest/
import java.util.*;
import java.lang.*;
public class RabbitsInAForest{
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<answers.length;i++){
            int freq = map.getOrDefault(answers[i],0)+1;
            map.put(answers[i],freq);
        }
        
        int sum=0;
        for(int num : map.keySet()){
            int gs = num+1;
            sum +=(Math.ceil(map.get(num)*1.0/gs))*gs;
        }
        return sum;
        
    }
}