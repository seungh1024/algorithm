print ('sex')
print (1e9)
print(72.25e1)

a= 0.3 + 0.6
print(a)
if a == 0.9:
    print(True)
else:
    print(False)

print(3//2)
print(3%2)

n=4
m=3
array = [ [0] * m for _ in range(n)]
print(array)

list1 = [1,2,3,4,5]
list2 = [5,6,7,8,9,10]
def fun(list1,list2):
    return list1+list2
result = map(fun,list1,list2)
result2 = map(lambda a,b: a+b,list1,list2)
print(list(result))
print(list(result2))
