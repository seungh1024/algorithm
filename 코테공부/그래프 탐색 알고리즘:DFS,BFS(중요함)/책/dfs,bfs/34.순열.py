from itertools import permutations

n = list(map(int,input().split()))
print(n)

result = list(map(list,permutations(n,len(n))))
print(result)
print(len(result))