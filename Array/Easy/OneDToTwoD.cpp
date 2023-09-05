// https://leetcode.com/problems/convert-1d-array-into-2d-array/
#include<bits/stdc++.h>
class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        if(m*n!=original.size())return {};
        int pos=0;
         vector<vector<int>>ans(m,vector<int>(n,0));
         while(pos<original.size()){
             ans[pos/n][pos%n]=original[pos];
             pos++;
         }
          return ans;
    }
};