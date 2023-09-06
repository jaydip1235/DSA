// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
#include<bits/stdc++.h>
class Solution {
public:
    static bool isPal(string s){
        int i=0,j=s.size()-1;
        while(i<=j){
            if(s[i]!=s[j])return false;
            i++;
            j--;
        }
        return true;
    }

    string firstPalindrome(vector<string>& words) {
        for(int i=0;i<words.size();i++){
            if(isPal(words[i]))return words[i];
        }
        return "";
    }
};