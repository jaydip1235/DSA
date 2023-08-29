// https://leetcode.com/problems/excel-sheet-column-title/description/
#include<bits/stdc++.h>
class Solution {
public:
    string convertToTitle(int col) {
        string ans="";
        while(col>0){
            int rem=(col-1)%26;
            ans.push_back(rem+'A');
            col=(col-1)/26;
        }
         reverse(ans.begin(), ans.end()); 
         return ans;
    }
};