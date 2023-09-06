// https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
#
class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        map<int,int>mp;
        int ans=0;
        for(int i=0;i<dominoes.size();i++){
            int f=dominoes[i][0];
            int s=dominoes[i][1];
            int fi=f*10 + s;
            int si=s*10 + f;
            if(mp.find(fi)!=mp.end()){
                ans+=mp[fi];
            }else if(mp.find(si)!=mp.end()){
                ans+=mp[si];
            }
            if(fi!=si){
            mp[fi]++;
            mp[si]++;
            }
            else{
             mp[fi]++;
            }
        }
        return ans;
    }
};