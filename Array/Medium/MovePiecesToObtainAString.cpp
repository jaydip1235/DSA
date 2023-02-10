// https://leetcode.com/problems/move-pieces-to-obtain-a-string/
#include<bits/stdc++.h>
class Solution {
public:
    bool canChange(string start, string target) {
        if(start.size()!=target.size())return false;
        int sp=0;
        int tp=0;
        while(sp<start.size() || tp<target.size()){
            while(sp<start.size() && start[sp]=='_')sp++;
            while(tp<target.size() && target[tp]=='_')tp++;
            if(sp==start.size() && tp==target.size())return true;
            if(sp==start.size() || tp==target.size() || start[sp]!=target[tp])return false;
            if(sp<start.size() && tp<target.size()){
            if(target[tp] == 'L' && sp < tp) {
                    return false;
                }

                if(target[tp] == 'R' && sp > tp) {
                    return false;
                }
            }
            tp++;
            sp++;
        }
        return true;
    }
};