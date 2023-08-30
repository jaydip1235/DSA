// https://leetcode.com/problems/decode-xored-array/description/
#include<bits/stdc++.h>
class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        vector<int>ans;
        ans.push_back(first);
        for(int i=0;i<encoded.size();i++){
            ans.push_back(first ^ encoded[i]);
            first^=encoded[i];
        }
        return ans;  
    }
};