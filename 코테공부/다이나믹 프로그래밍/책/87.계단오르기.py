from collections import defaultdict

n = int(input())

d = defaultdict(list)
d[0] = [0]
# print(d)

#사전자료형 이용해서 n+1까지의 범위로 해서 n계단까지 입력받음
for i in range(1,n+1):
    #1,2의 두가지 계단의 경우의 수
    for j in range(1,3):
        #이전 계단의 모든 경우의수 만큼 반복
        for k in range(len(d[i-1])):
            # print('k:',k)
            # print('j:',j)
            a = d[i-1][k] +j
            # print('a:',a)
            #더한 계단이 목표치 아래인 것만 추가해줌
            if a <= n:
                #각
                d[a].append(a)
print(len(d[n]))
#나처럼 하면 타임아웃 걸림
print('-----------------------')
#모범답안
#피보나치 수열

dp = defaultdict(int)
def fibo(n):
    if n <= 2:
        return n
    if dp[n]:
        return dp[n]
    dp[n] =  fibo(n-1) + fibo(n-2)
    return dp[n]

print(fibo(n))