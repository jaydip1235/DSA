// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
#include<bits/stdc++.h>
class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rsum, vector<int>& csum) {
        int n=rsum.size();
        int m=csum.size();
        int i=0,j=0;
        vector<vector<int>>ans(n,vector<int>(m,0));
        while(i<n && j<m){
            int x=min(rsum[i],csum[j]);
            ans[i][j]=x;
            rsum[i]-=x;
            csum[j]-=x;
            if(rsum[i]==0)i++;
            if(csum[j]==0)j++;
        }
        return ans;
        
    }
};