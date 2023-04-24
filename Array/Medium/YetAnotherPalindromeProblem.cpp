// Problem Link: https://www.codechef.com/START60B/problems/ARRPAL

// Solution:

#include<bits/stdc++.h>
using namespace std; 
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)

int main(){
    fast;
    int t = 1;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int m = n/2;
        int arr[n];
        for(int i = 0; i < n; i++) cin>>arr[i];
        long long int sum = 0, f = 0;
        for(int i = m - 1; i >= 0; i--){
            long long int p = arr[i] + sum;
            if(p > arr[n - i - 1]){
                f = 1;
                break;
            }
            sum += arr[n - i - 1] - p;
        }
        if(f) sum = -1;
        cout<<sum<<"\n";
    }
    return 0;
}