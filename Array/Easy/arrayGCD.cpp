// https://leetcode.com/problems/find-greatest-common-divisor-of-array/
#include<bits/stdc++.h>
class Solution {
public:
    int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    int findGCD(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return gcd(nums[0], nums[nums.size() - 1]);
    }
};
