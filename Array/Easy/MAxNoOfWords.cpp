// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/description/
#include<bits/stdc++.h>
class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        int ans=0;
        for(int i=0;i<sentences.size();i++){
            int space=0;
            for(int j=0;j<sentences[i].size();j++){
                if(sentences[i][j]==' '){
                    space++;
                }
            }
            ans=max(ans,space+1);
        }
        return ans;
    }
};