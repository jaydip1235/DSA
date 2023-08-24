// https://practice.geeksforgeeks.org/problems/length-of-longest-subarray0440/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
#include<bits/stdc++.h>
long long int longestSubarry(long long int arr[], long long int n) {
    long long int ans=0;
    long long int len=0;
    for(int i=0;i<n;i++){
        if(arr[i]>0){
            len+=1;
            ans=max(ans,len);
        }
        else{
            len=0;
        }
    }
    return ans;
    
}