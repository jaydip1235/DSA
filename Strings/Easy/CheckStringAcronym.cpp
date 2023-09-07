// https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/
#include<bits/stdc++.h>
class Solution {
public:
    bool isAcronym(vector<string>& words, string s) {
        string res="";
        for(int i=0;i<words.size();i++){
            res+=words[i][0];
        }
        return res==s;
    }
};