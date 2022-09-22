// https://leetcode.com/problems/hand-of-straights/
#include<bits/stdc++.h>
class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        if(hand.size()%groupSize)return false;
        map<int,int> mp;
        for(int i=0;i<hand.size();i++){
            mp[hand[i]]++;
        }
        while(mp.size()>0){
            int ff = mp.begin()->first ;
            for(int j=ff;j<ff+groupSize;j++){
                if(mp.find(j)==mp.end())return false;
                int cnt=mp[j];
                if(cnt==1)mp.erase(j);
                else mp[j]--;
            }
        }
        return true;
    }
};