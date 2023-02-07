// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
#include<bits/stdc++.h>
class Solution {
public:
    int minimumLength(string s) {
        int n=s.size();
        int i=0;
        int j=n-1;
        while(i<j && s[i]==s[j]){
            char ch=s[i];
            while(s[i]==ch && i<=j){
                i++;
            }
            while(s[j]==ch && i<=j){
                j--;
            }
        }
        return (j-i+1);
    }
};