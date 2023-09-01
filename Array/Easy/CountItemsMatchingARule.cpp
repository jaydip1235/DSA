// https://leetcode.com/problems/count-items-matching-a-rule/description/
#include<bits/stdc++.h>
class Solution {
public:
    int countMatches(vector<vector<string>>& items, string ruleKey, string ruleValue) {
        int index=0;
        if(ruleKey=="color")index=1;
        if(ruleKey=="name")index=2;
        int ans=0;
        for(int i=0;i<items.size();i++){
            vector<string>v=items[i];
            if(v[index]==ruleValue)ans++;
        }
        return ans;
    }
};