// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
#include<bits/stdc++.h>
class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string s1="";
        string s2="";
        for(string s:word1){
            s1+=s;
        }
         for(string s:word2){
            s2+=s;
        }
        return s1==s2;
    }
};