from itertools import permutations

data =['A','B','C']

result = list(permutations(data,3))
print(result)
print(result[0][1])
result1 = map(lambda a,b,c: a+b+c,result[0][0],result[0][1],result[0][2])
print(list(result1))