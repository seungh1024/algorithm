nums = list(map(int,input().split()))

result = []

def dfs(data,index):
    
    result.append(data)
    for i in range(index,len(nums)):

        dfs(data+[nums[i]],i+1) 

dfs([],0)
print(nums[-1])

print(result)