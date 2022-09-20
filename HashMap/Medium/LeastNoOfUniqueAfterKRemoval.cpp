// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
#include<bits/stdc++.h>
class Solution {
public:

int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
    map<int,int>mp;
        for(int i=0;i<arr.size();i++){
            mp[arr[i]]++;
        }
    multimap<int, int> mm;
  
    for (auto& it : mp) {
        mm.insert({ it.second, it.first });
    }
       vector<int>v;
        for(auto it=mm.begin();it!=mm.end();it++){
            if(k>=it->first){
                k-=it->first;
                v.push_back(it->second);
            }else{
                break;
            }
        }
        return mm.size()-v.size();
    }
};









