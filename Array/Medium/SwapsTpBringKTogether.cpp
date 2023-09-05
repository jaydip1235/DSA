// https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
#include<bits/stdc++.h>
class Solution
{
public:
    int minSwap(int arr[], int n, int k) {
    
        int fav=0,nonFav=0;
       
        for(int i=0;i<n;i++){
            if(arr[i]<=k)fav++;
        }
        for(int i=0;i<fav;i++){
           if(arr[i]>k)nonFav++;
        }
        int l=0,r=fav-1,res=INT_MAX;
        
        while(r<n){
            res=min(res,nonFav);
            r++;
            if(r<n && arr[r]>k)nonFav++;
            if(l<n && arr[l]>k)nonFav--;
            l++;
        }
        return (res==INT_MAX)?0:res;
    }
};