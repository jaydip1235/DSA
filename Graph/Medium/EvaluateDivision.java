// https://leetcode.com/problems/evaluate-division/
import java.util.*;
public class EvaluateDivision{
     static class Node{
        String key;
        double val;
        
        Node(String k, double v){
            key=k;
            val=v;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            
        Map<String,List<Node>> g = build(equations,values);
        
        double []result = new double[queries.size()];
        
        for(int i=0;i<queries.size();i++){
            result[i]=dfs(queries.get(i).get(0),queries.get(i).get(1),new HashSet(),g); 
        }
        return result;
    }
    
    public double dfs(String src, String dest, HashSet<String>visited, Map<String,List<Node>> g ){
        if(!(g.containsKey(src) && g.containsKey(dest))) return -1.0;
        if(src.equals(dest))return 1.0;
        visited.add(src);
        for(Node ng:g.get(src)){
            if(!visited.contains(ng.key)){
                double ans = dfs(ng.key,dest,visited,g);
                if(ans!=-1.0){
                    return ans*ng.val;
                }
            }
        }
        return -1.0;
    }
    
    
    private Map<String,List<Node>> build(List<List<String>> eq, double[] values){
        Map<String,List<Node>> g = new HashMap<>();
        
        for(int i=0;i<values.length;i++){
            String src = eq.get(i).get(0);
            String dest = eq.get(i).get(1);
            g.putIfAbsent(src,new ArrayList<>());
            g.putIfAbsent(dest,new ArrayList<>());
            g.get(src).add(new Node(dest,values[i]));
            g.get(dest).add(new Node(src,1/values[i]));
        }
        return g;
    }
}