// https://leetcode.com/problems/number-of-senior-citizens/description/
#include<bits/stdc++.h>
class Solution {
public:
    int countSeniors(vector<string>& details) {
        int ans = 0;
        for(int i = 0; i < details.size(); i++){
            if(stoi(details[i].substr(11,2))>60)
                ans++;
        }
        return ans;
    }
};
