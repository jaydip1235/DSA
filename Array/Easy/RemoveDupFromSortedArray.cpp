// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
#include<bits/stdc++.h>
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i=1,j;
        for(int j=1;j<nums.size();j++){
            if(nums[j]!=nums[j-1]){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
};