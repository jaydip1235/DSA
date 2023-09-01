// https://leetcode.com/problems/counting-bits/description/
#include<bits/stdc++.h>
class Solution {
public:
    vector<int> countBits(int n) {
        vector<int>ans(n+1,0);
        for(int i=1;i<=n;i++){
            if(i%2==1){
                ans[i]=ans[i-1]+1;
            }else{
                ans[i]=ans[i>>1];
            }
        }
        return ans;
    }
};