// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
#include<bits/stdc++.h>
class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int res=0;
        for(auto num:nums) {
            res+=(int)log10(num)&1;
        }
        return res;
    }
};