//https://leetcode.com/problems/four-divisors/
#include<bits/stdc++.h>
class Solution {
public:
 int sumFourDivisors(vector<int>& nums) {
        int ans=0;
        for(int i=0;i<nums.size();i++){
            int tempans=0;
            int count=2;
            int n=nums[i];
            for(int j=2;j*j<=n;j++){
                if(n%j==0){
                    if(n/j!=j){
                        tempans+=j+(n/j);
                        count+=2;
                    }
                    else{
                        tempans+=j;
                        count++;
                    }
                }
            }
            if(count==4)ans+=tempans+1+n;
        }
        return ans;
    }
};