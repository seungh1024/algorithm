from itertools import combinations

n,k = map(int,input().split())
print(n,k)

data = []
for i in range(n):
    data.append(i+1)
print(data)

result = list(map(list,combinations(data,k)))

print(result)