// https://leetcode.com/problems/construct-k-palindrome-strings/
#include<bits/stdc++.h>
class Solution
{
public:
    bool canConstruct(string s, int k)
    {
        int arr[26] = {0};
        for (int i = 0; i < s.size(); i++)
        {
            arr[s[i] - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++)
        {
            if (arr[i] % 2)
                odd++;
        }
        if (k > s.size())
            return false;
        if (k < odd)
            return false;
        return true;
    }
};