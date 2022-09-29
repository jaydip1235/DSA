// https://leetcode.com/problems/reverse-words-in-a-string/
#include<bits/stdc++.h>
class Solution
{
public:
    string reverseWords(string s)
    {
        stack<string> st;
        int n = s.size();
        string word = "";
        for (int i = 0; i < n; i++)
        {
            while (i < n && s[i] == ' ')
                i++;
            while (i < n && s[i] != ' ')
            {
                word += s[i];
                i++;
            }
            st.push(word);
            word = "";
        }
        string ans = "";
        while (!st.empty())
        {
            if (ans == "")
            {
                ans = st.top();
                st.pop();
            }
            else
            {
                ans = ans + " " + st.top();
                st.pop();
            }
        }
        return ans;
    }
};