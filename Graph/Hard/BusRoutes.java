public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int s, int t) {
        int level=0;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                int busstop = routes[i][j];
                ArrayList<Integer> buses = map.getOrDefault(busstop,new ArrayList<>());
                buses.add(i);
                map.put(busstop,buses);
            }
        }
        LinkedList<Integer>q = new LinkedList<>();
        HashSet<Integer> busesvis = new HashSet<>();
        HashSet<Integer>busstopvis = new HashSet<>();
        q.addLast(s);
        busstopvis.add(s);
        
        while(q.size()>0){
            int sz = q.size();
            while(sz-->0){
                int rem = q.removeFirst();
                if(rem==t)return level;
                ArrayList<Integer> bus = map.get(rem);
                for(int b:bus){
                    if(busesvis.contains(b))continue;
                    int []arr = routes[b];
                    for(int i=0;i<arr.length;i++){
                        if(busstopvis.contains(arr[i]))continue;
                        q.addLast(arr[i]);
                        busstopvis.add(arr[i]);
                    }
                    busesvis.add(b);  
                }
            }
            level++;   
        }
        
        return -1;
        
    }
}
