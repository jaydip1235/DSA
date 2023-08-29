// https://leetcode.com/problems/merge-strings-alternately/description/
#include<bits/stdc++.h>
class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string ans="";
        int n1 = word1.size();
        int n2 = word2.size();
        int i=0,j=0;
        while(i<n1 && j<n2){
            ans.push_back(word1[i++]);
            ans.push_back(word2[j++]);
        }
        while(i<n1){
             ans.push_back(word1[i++]);
        }
        while(j<n2){
             ans.push_back(word2[j++]);
        }
        return ans;
    }
};