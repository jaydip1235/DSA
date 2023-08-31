// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
#include<bits/stdc++.h>
class Solution {
public:
    int maximumCount(vector<int>& v) {
        int n = v.size();
        int firstPos = lower_bound(v.begin(),v.end(),1) - v.begin();
        int firstZero = lower_bound(v.begin(),v.end(),0) - v.begin();
        return max(n - firstPos,firstZero);
    }
};