#User function Template for python3

#Function to find maximum circular subarray sum.
def circularSubarraySum(arr,n):
    # Find the maximum subarray sum without considering the circular property
    max_sum = arr[0]
    cur_sum = arr[0]
    for i in range(1, n):
        cur_sum = max(arr[i], cur_sum + arr[i])
        max_sum = max(max_sum, cur_sum)

    # Find the minimum subarray sum without considering the circular property
    min_sum = arr[0]
    cur_sum = arr[0]
    for i in range(1, n):
        cur_sum = min(arr[i], cur_sum + arr[i])
        min_sum = min(min_sum, cur_sum)

    # Find the total sum of the array
    total_sum = sum(arr)

    # Find the maximum subarray sum considering the circular property
    circular_sum = total_sum - min_sum
    if circular_sum == 0:
        return max_sum
    return max(max_sum, circular_sum)
    
    
  

