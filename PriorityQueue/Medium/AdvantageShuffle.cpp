// https://leetcode.com/problems/advantage-shuffle/
#include<bits/stdc++.h>
class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(),nums1.end());
        priority_queue<pair<int,int>> pq;
        for(int i=0;i<nums2.size();i++){
            pq.push({nums2[i],i});
        }
        
        vector<int>ans(nums1.size(),0);
        int l=0,r=nums1.size()-1;
        while(!pq.empty()){
            if(nums1[r]>pq.top().first){
                ans[pq.top().second]=nums1[r--];
                pq.pop();
            }else{
                ans[pq.top().second]=nums1[l++];
                pq.pop();           
            }
        }
        
        return ans;
    }
};