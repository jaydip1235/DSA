#include <bits/stdc++.h>
#define MOD (int)1e9 + 7
#define int long long
using namespace std;
signed main()
{
    ios_base::sync_with_stdio(0), cin.tie(0);
    cout.tie(0);
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)cin>>arr[i];
    int maxi=INT_MIN;
    
    for(int i=0;i<=31;i++){
        int count=0;
        for(int j=0;j<n;j++){
            if (arr[j] & (1 << (i - 1)))count++;
        }
        maxi=max(maxi,count);
    }
    cout<<maxi<<endl;
    return 0;
}