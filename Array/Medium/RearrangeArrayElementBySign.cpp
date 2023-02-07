// https://leetcode.com/problems/rearrange-array-elements-by-sign/
#include<bits/stdc++.h>
class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector<int>positive;
        vector<int>negative;
        for(int a:nums){
            if(a>0){
                positive.push_back(a);
            }else{
                negative.push_back(a);
            }
        }
        vector<int>ans;
        for(int i=0;i<positive.size();i++){
            ans.push_back(positive[i]);
            ans.push_back(negative[i]);
        }
        return ans;
    }
};