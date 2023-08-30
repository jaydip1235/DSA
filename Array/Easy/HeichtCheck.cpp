// https://leetcode.com/problems/height-checker/description/
#include<bits/stdc++.h>
class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> v;
        int cnt=0;
        v= heights;
        sort(heights.begin(),heights.end());
        for(int i=0;i<v.size();i++)
        {
            if(v[i] != heights[i])
            cnt++;
        }
        return cnt;
    }
};