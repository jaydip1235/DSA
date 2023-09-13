//https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
public:
    vector<int> singleNumber(vector<int> nums) 
    {
        int xorans=0;
        for(int i=0;i<nums.size();i++){
            xorans^=nums[i];
        }
        int s1=0,s2=0;
        xorans=xorans & ~(xorans-1);
        for(int i=0;i<nums.size();i++){
            if(nums[i]&xorans)s1^=nums[i];
            else s2^=nums[i];
        }
         vector<int> ans;
         ans.push_back(min(s1,s2));
         ans.push_back(max(s1,s2));
         return ans;
    }
};