import java.util.*;
public class FindMedianFromDataStream {
    class MedianFinder {


        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);

        public MedianFinder() {

        }

    public void addNum(int num) {
       
        int maxHsize = maxH.size();
        int minHsize = minH.size();
        if(maxHsize==0){
            maxH.add(num);
        }        
        else if(maxHsize==minHsize){
            if(num<minH.peek()){
                maxH.add(num);
            }
            else{
                int temp = minH.remove();
                maxH.add(temp);
                minH.add(num);
            }
        }
        else{
            if(minH.size()==0){
                if(num>maxH.peek()){
                    minH.add(num);
                }
                else{
                    int temp = maxH.remove();
                    minH.add(temp);
                    maxH.add(num);
                }
            }
            else if(num>=minH.peek()){
                minH.add(num);
            }
            else{
                if(num<maxH.peek()){
                int temp = maxH.remove();
                minH.add(temp);
                maxH.add(num);
                }
                else{
                    minH.add(num);
                }
            }
        }
    }

        public double findMedian() {
            if(maxH.size()==minH.size()){
                return (double)((double)maxH.peek()+minH.peek())/2;
            }
            else{
                return maxH.peek();
            }
        }
    }
}
