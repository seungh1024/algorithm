from collections import defaultdict

n = int(input())

d=[0]
d.append(1)
d.append(1)

# print(d)
for i in range(3,n+1):
    d.append(d[i-1]+d[i-2])

print(n,'번째 피보나치 수(보텀업):',d[n])

# def fib(n):
#     if n<=1:
#         return n
#     return fib(n-1)+fib(n-2)

# print(n,'번쨰 피보나치 수(재귀형):',fib(n)) #재귀만 써서 느림

dp = defaultdict(int)

def mem(n):
    if n<=1:
        return n
    if dp[n]:
        return dp[n]
    dp[n] = mem(n-1) + mem(n-2)
    return dp[n]

print(n,'번째 피보나치 수(메모이제이션):',mem(n))


#변수 두개만 이용해서 공간 절약하기
def two(n):
    x,y = 0,1
    for i in range(n):
        x,y = y,x+y
    return x
print(n,'번째 피보나치 수(변수 두개만 이용):',two(n))
