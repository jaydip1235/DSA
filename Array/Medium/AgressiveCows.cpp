//https://www.spoj.com/problems/AGGRCOW/
#include <bits/stdc++.h>
using namespace std;

bool isPossible(vector<int> &stalls, int minDist, int k)
{
    int cows = 1; // we already place it at the first available slot i.e stalls[0]  ( GREEDY )
    int lastCowPosition = stalls[0];
    for (int i = 1; i < stalls.size(); i++)
    {
        if (stalls[i] - lastCowPosition >= minDist)
        {
            cows++;
            lastCowPosition = stalls[i];
            if (cows >= k)
                return true;
        }
    }
    return false;
}

int aggressiveCows(vector<int> &stalls, int k)
{
    int n = stalls.size();
    sort(stalls.begin(), stalls.end());
    int low = 1, high = stalls[n - 1] - stalls[0]; // just take low=0 and high = 1000000 any large number if this seems tricky
    int res;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (isPossible(stalls, mid, k))
        {
            res = mid;
            low = mid + 1;
        }
        else
            high = mid - 1;
    }
    return res;
}

int main()
{
    int t;
    cin>>t;
    while(t--){
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for(int i = 0; i < n; i++) cin >> arr[i];
    cout << aggressiveCows(arr, k)<<endl;
    }
    return 0;
}