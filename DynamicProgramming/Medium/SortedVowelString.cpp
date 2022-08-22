// https://leetcode.com/problems/count-sorted-vowel-strings/
#include<bits/stdc++.h>
class Solution
{
public:
    int countVowelStrings(int n)
    {

        vector<int> ans(5, 1);
        for (int i = 2; i <= n; i++)
        {
            for (int j = 3; j >= 0; j--)
            {
                ans[j] = ans[j] + ans[j + 1];
            }
        }
        int val = 0;
        for (int i : ans)
            val += i;
        return val;
    }
};