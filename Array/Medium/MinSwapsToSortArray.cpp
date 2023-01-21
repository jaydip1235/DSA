// https://practice.geeksforgeeks.org/problems/minimum-swaps/1
#include<bits/stdc++.h>
class Solution 
{
    public:
    
	int minSwaps(vector<int>&nums)
	{
	   vector<pair<int,int>>v;
	   for(int i=0;i<nums.size();i++){
	       v.push_back({nums[i],i});
	   }
	   sort(v.begin(),v.end());
	   int ans=0;
	   for(int i=0;i<v.size();i++){
	       pair<int,int>p = v[i];
	       int index=p.second;
	       int value=p.first;
	       if(i!=index){
	           ans++;
	           swap(v[i],v[index]);
	           i--;
	       }
	   }
	   return ans;
	}
};