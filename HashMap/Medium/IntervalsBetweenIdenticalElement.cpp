// https://leetcode.com/problems/intervals-between-identical-elements/
#include<bits/stdc++.h>
class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        unordered_map<long long, vector<long long>>m;
        int n = arr.size();
        vector<long long>pre(n,0),suf(n,0),ans(n,0);
        for(int i = 0;i<n;i++){
            m[arr[i]].push_back(i);
        }
        for(auto [x, y]:m){
            for(int i=1;i<y.size();i++){
                pre[y[i]]=  pre[y[i-1]]+  i*(y[i]-y[i-1]);
            }
        }
        for(auto [x, y]:m){
            for(int i=y.size()-2;i>=0;i--){
                suf[y[i]]=  suf[y[i+1]] + (y.size()-1-i)*(y[i+1]-y[i]);
            }
        }
        for(int i=0;i<n;i++)
            ans[i]=(pre[i]+suf[i]);
        return ans;
    }
};