from collections import deque

nums = list(map(int,input().split()))
k = int(input())

# print(nums,k)

Q = deque()
for i in range(k-1):
    Q.append(nums[i])

result = []
for i in range(k-1,len(nums)):
    Q.append(nums[i])
    result.append(max(Q))
    Q.popleft()
print(result)