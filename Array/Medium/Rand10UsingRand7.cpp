// https://leetcode.com/problems/implement-rand10-using-rand7/
#include<bits/stdc++.h>
class Solution {
public:
    int rand10() {
        int temp=(rand7()-1)*7+(rand7());
        if(temp>=41)return rand10();
        return temp%10+1; 
    }
};