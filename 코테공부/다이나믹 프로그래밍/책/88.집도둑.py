from collections import defaultdict

data = list(map(int,input().split()))

dp = defaultdict(int)
dp[0] = data[0]
dp[1] = max(data[0],data[1])
for i in range(2,len(data)):
    # if data[i]+data[i-2] >= data[i-1]:
    #     data[i] = data[i]+data[i-2]
    dp[i] = max(data[i]+dp[i-2],dp[i-1])
print(dp[len(data)-1])

print('------------책-----------')

def fibo(nums):
    if not nums:
        return 0
    if len(nums) <= 2:
        return max(nums)
    d = defaultdict(int)
    d[0],d[1] = nums[0],max(nums[0],nums[1])

    for i in range(2,len(nums)):
        d[i] = max(d[i-1],d[i-2]+nums[i])
    
    print(d[len(data)-1])

fibo(data)