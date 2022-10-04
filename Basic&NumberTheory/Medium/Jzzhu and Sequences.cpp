https://codeforces.com/contest/450/problem/B

#include<iostream>
#include<cmath>
#include<string>
#include<climits>
#include<vector>
#include<algorithm>
#include<iomanip>
#include<bitset>
#include<map>
#include<set>
#include<unordered_map>
#include<unordered_set>
#include<iterator>
#include<stack>
#include<queue>
#include<list>
#define endl "\n"
#define fastio ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define ll long long
#define all(x) x.begin(),x.end
#define vi vector<int>
#define vl vector<ll>
#define fi(i,x,n) for(int i=x;i<n;i++)
#define fl(i,x,n) for(ll i=x;i<n;i++)
const int m=1e9+7;
using namespace std;
int main(){
    fastio;
    ll x,y,n;
    cin>>x>>y;
    cin>>n;
    if(n%6==1)  cout<<(x%m+m)%m<<endl;
    else if(n%6==2) cout<<(y%m+m)%m<<endl;
    //else if(n%6==3)  cout<<(y%m-x%m+m)%m<<endl;
    else if(n%6==3)  cout<<((y%m+m)%m-(x%m+m)%m+m)%m<<endl;
    else if(n%6==4)  cout<<(m-x)%m<<endl;
    else if(n%6==5)  cout<<(m-y)%m<<endl;
    //else if(n%6==0)  cout<<(m-x+y)%m<<endl;
    else if(n%6==0)  cout<<((m+x-y)%m+m)%m<<endl;

return 0;
}
