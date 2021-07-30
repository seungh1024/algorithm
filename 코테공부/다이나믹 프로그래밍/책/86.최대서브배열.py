data = list(map(int,input().split()))
print(data)
a,b = 0,0
for i in range(1,len(data)):
    a = data[i] + data[i-1]
    b = data[i]
    # if a < b:
    #     data[i] = b
    # else:
    #     data[i] = a
    data[i] = max(a,b) #하면 될듯

print(max(data))

print('-------------모범답안--------------')
nums = list(map(int,input().split()))
for i in range(1,len(nums)):
    nums[i] += nums[i-1] if nums[i-1]>0 else 0
print(max(nums))