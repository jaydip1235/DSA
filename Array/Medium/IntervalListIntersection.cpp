// https://leetcode.com/problems/interval-list-intersections/
#include<bits/stdc++.h>
class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& f, vector<vector<int>>& s) {
        vector<vector<int>> ans;
        int i=0;
        int j=0;
        while(i<f.size() && j<s.size()){
            vector<int>ff=f[i];
            vector<int>ss=s[j];
            int cst=max(ff[0],ss[0]);
            int cet=min(ff[1],ss[1]);
            if(cst<=cet){
                ans.push_back({cst,cet});
            }
            if(ff[1]>ss[1]){
                j++;
            }else if(ff[1]<ss[1]){
                i++;
            }else{
                i++;j++;
            }
        }
        return ans;
    }
};