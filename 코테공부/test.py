# def crossBridge(steps):
#     cnt = 0
#     current = 0
#     n = len(steps)
#     while current<n:
#         current += steps[current]
#         cnt += 1
#     return cnt

# print(crossBridge([1, 1, 2, 3, 5]))

# def isPrince(frogList):
#     # 여기에 코드를 작성해 주세요!
#     ans=[]
#     for i in frogList:
#         if i[0]=="F":
#             ans.append(i)
#             return ans
            
    

# print(isPrince(['Alice', 'Bob', 'Frog']))

# a,b = map(int,input().split())
# num = 0
# if(a == 1 or b == 1):
#     if(a == 1):
#         print(a)
#     else:
#         print(b)
# else:
#     maxNum = max(a,b)
#     minNum = min(a,b)
#     for i in range(1,minNum+1):
#         if (maxNum%i ==0 and minNum%i == 0):
#             num = i
#     if num == 1:
#         print(a*b)
#     else:
#         print(int(maxNum*minNum/num))

# def GCD(x,y):
#     while(y):
#         x,y = y,x%y
#     return x

# def LCM(x,y):
#     result = (x*y)//GCD(x,y)
#     return result

# print(LCM(a,b))

num = int(input())
if num%2==0:
    print("*{}*{}*".format(" "*num," "*num))
    print("{}*{}*".format(" "*int((num+2)/2)," "*(num-1)))
else:
    print("*{}*{}*".format(" "*num," "*num))
    print("{}*{}*".format(" "*int((num+2)/2)," "*num))