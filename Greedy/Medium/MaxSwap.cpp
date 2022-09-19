// https://leetcode.com/problems/maximum-swap/
#include<bits/stdc++.h>
class Solution {
public:
    int maximumSwap(int num) {
        string s= to_string(num); 
        int arr[10];
        memset(arr,0,sizeof arr);
        
        for(int i=0;i<s.size();i++){
            arr[s[i]-'0']=i;
        }
        int f=0;
        for(int i=0;i<s.size();i++){
            int dig=s[i]-'0';
            for(int j=9;j>dig;j--){
                if(arr[j]>i){
                    swap(s[i],s[arr[j]]);
                    f=1;
                    break;
                }
            }
            if(f==1)break;
        }
        
        
        return stoi(s);
    }
};