// https://leetcode.com/problems/merge-similar-items/description/
#include<bits/stdc++.h>
class Solution {
public:

    vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1, vector<vector<int>>& items2) {
         vector<vector<int>>ans;
         map<int,int>mp;
         for(int i=0;i<items1.size();i++){
             mp[items1[i][0]]=items1[i][1];
         }
         for(int i=0;i<items2.size();i++){
             if(mp.find(items2[i][0])!=mp.end()){
                 ans.push_back({items2[i][0],mp[items2[i][0]]+items2[i][1]});
                 mp.erase(items2[i][0]);
             }else{
                  ans.push_back({items2[i][0],items2[i][1]});
             }
         }
         for(auto it=mp.begin();it!=mp.end();it++){
             ans.push_back({it->first,it->second});
         }
         sort(ans.begin(),ans.end());
         return ans;
    }
};