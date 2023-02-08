// https://leetcode.com/problems/insert-interval/
#include<bits/stdc++.h>
class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& in, vector<int>& ni) {
        vector<vector<int>> ans;
        int i=0;
        while(i<in.size()){
            if(in[i][0]<ni[0]){
                ans.push_back(in[i]);
                i++;
            }else{
                break;
            }
        }

        if(ans.size()==0 || ni[0]>ans.back()[1]){
            ans.push_back(ni);
        }
        else{
            vector<int>&ele = ans.back();
            ele[1]=max(ele[1],ni[1]);
        }
        while(i<in.size()){
            vector<int>&ele = ans.back();
            if(ele[1]>=in[i][0]){
                ele[1]=max(ele[1],in[i][1]);
            }else{
                ans.push_back(in[i]);
            }
            i++;
        }
    return ans;
    }
};