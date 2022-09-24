// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
#include<bits/stdc++.h>
class Solution
{
public:
    int maxVowels(string s, int k)
    {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < k; i++)
        {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
            {
                count++;
            }
        }
        ans = max(ans, count);
        for (int i = k; i < s.size(); i++)
        {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
            {
                count++;
            }
            if (s[i - k] == 'a' || s[i - k] == 'e' || s[i - k] == 'i' || s[i - k] == 'o' || s[i - k] == 'u')
            {
                count--;
            }
            ans = max(ans, count);
        }
        return ans;
    }
};