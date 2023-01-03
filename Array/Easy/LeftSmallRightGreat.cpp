// https://practice.geeksforgeeks.org/problems/unsorted-array4925/1
class Solution{
int findElement(int arr[], int n)
{
    vector<int> l(n, 0), r(n, 0);
    l[0] = arr[0];
    r[n - 1] = arr[n - 1];
    for (int i = 1; i < n; i++)
        l[i] = max(arr[i], l[i - 1]);
    for (int i = n - 2; i >= 0; i--)
        r[i] = min(arr[i], r[i + 1]);
    for (int i = 1; i < n - 1; i++)
    {
        if (l[i - 1] <= arr[i] && arr[i] <= r[i + 1])
            return arr[i];
    }
    return -1;
}
}