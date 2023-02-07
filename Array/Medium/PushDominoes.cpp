// https://leetcode.com/problems/push-dominoes/
#include<bits/stdc++.h>
class Solution {
public:

    void solve(vector<char>& arr, int i, int j){
        if(arr[i]=='L' && arr[j]=='L'){
            for(int k=i+1;k<j;k++){
                arr[k]='L';
            }
        }else if(arr[i]=='R' && arr[j]=='R'){
            for(int k=i+1;k<j;k++){
                arr[k]='R';
            }
        }else if(arr[i]=='L' && arr[j]=='R'){

        }else if(arr[i]=='R' && arr[j]=='L'){
            int diff=j-i;
            int mid=(i+j)/2;
            if(diff%2==0){
            for(int k=i+1;k<mid;k++){
                arr[k]='R';
            }
           for(int k=mid+1;k<j;k++){
                arr[k]='L';
            }
            }else{
            for(int k=i+1;k<=mid;k++){
                arr[k]='R';
            }
           for(int k=mid+1;k<j;k++){
                arr[k]='L';
            }
            }
        }
    }

    string pushDominoes(string s) {
        int n=s.size();
        vector<char>arr(n+2);
        arr[0]='L';
        arr[n+1]='R';
        for(int i=1;i<arr.size()-1;i++){
            arr[i]=s[i-1];
        }
        int j=0;
        int k=1;
        while(k<arr.size()){
            while(arr[k]=='.')k++;
            if(k-j>1)
                solve(arr,j,k);
            j=k;
            k++;
        }
        string ans="";
        for(int i=1;i<arr.size()-1;i++){
            ans+=arr[i];
        }
        return ans;

    }
};