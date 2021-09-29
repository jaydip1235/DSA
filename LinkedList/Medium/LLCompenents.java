//https://leetcode.com/problems/linked-list-components/
import java.util.*;
public class LLCompenents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++)s.add(nums[i]);
        
        ListNode curr=head;
        ListNode prev = null;
        
        int ans=0;
        
        while(curr!=null){
            if(prev==null){
                if(s.contains(curr.val))ans++;
            }
            else if(!s.contains(prev.val) && s.contains(curr.val))ans++;
            prev=curr;
            curr=curr.next;
        }
        return ans;
    }
}
