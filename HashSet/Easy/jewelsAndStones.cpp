// https://leetcode.com/problems/jewels-and-stones/
#include<bits/stdc++.h>
class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        set<char>s;
        int ans=0;
        for(auto it:jewels)s.insert(it);
        for(auto it:stones){
            if(s.find(it)!=s.end())ans++;
        }
        return ans;
    }
};