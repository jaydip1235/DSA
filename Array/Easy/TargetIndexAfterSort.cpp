// https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
#include<bits/srdc++.h>
class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        int smaller = 0, larger = 0, n = nums.size();
        vector<int>res;
		for (int i : nums) {
			if (i < target)
				smaller++;
			else if (i > target)
				larger++;
		}
        for(int i = smaller; i < n - larger; i ++){
            res.push_back(i);
        }
        return res;
    }
};