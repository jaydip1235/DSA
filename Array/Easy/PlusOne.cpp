https : // leetcode.com/problems/plus-one/description/
#include <bits/stdc++.h>
        class Solution
{
public:
    vector<int> plusOne(vector<int> &digits)
    {

        int c = 1;
        vector<int> ans;

        for (int i = digits.size() - 1; i >= 0; i--)
        {
            int sum = digits[i] + c;
            int num = sum % 10;
            c = sum / 10;
            ans.insert(ans.begin(), num);
        }
        if (c > 0)
            ans.insert(ans.begin(), c);
        return ans;
    }
};