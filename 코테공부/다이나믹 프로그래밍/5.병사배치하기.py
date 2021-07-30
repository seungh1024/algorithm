n = int(input())
power = list(map(int,input().split()))
# print(n,power)

count = 0 #열외 수
d = []
d.append(power[0])
# print(d)
# print(d.pop())

for i in range(1,n):
    a = d.pop()
    if a> power[i]:
        d.append(a)
        d.append(power[i])
    else:
        d.append(power[i])
        count += 1
print(count)

print('------------------------------')
    
#문제 해결 아이디어
#-이 문제의 기본 아이디어는 가장 긴 증가하는 부분 수열(LIS)로 알려진 전형적인
# 다이나믹 프로그래밍 문제의 아이디어와 같다
#-예를 들어 하나의 수열 array = [4,2,5,8,4,11,15]이 있다고 하자
#   -이 수열의 가장 긴 증가하는 부분 수열은 [4,5,8,11,15]이다
#-본 문제는 가장 긴 감소하는 부분 수열을 찾는 문제로 치환할 수 있다. LIS알고리즘을
# 조금 수정하여 적용함으로써 정답을 도출할 수 있다.

#가장 긴 증가하는 부분 수열(LIS) 알고리즘을 확인해보면
#D[i] = array[i]를 마지막 원소로 가지는 부분 수열의 최대 길이
#점화식은 다음과 같다
#모든 0<=j<i에 대하여, D[i] = max(D[i],D[j]+1) if array[j]<array[i]

#가장 먼저 입력 받은 병사 정보의 순서를 뒤집는다
#가장 긴 증가하는 부분 수열 (LIS) 알고리즘을 수행하여 정답을 도출한다

n = int(input())
array = list(map(int,input().split()))
#순서를 뒤집어 '최장 증가 부분 수열'문제로 변환
array.reverse()

#다이나믹 프로그래밍을 위한 1차원 dp 테이블 초기화
dp = [1]*n

#가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
for i in range(1,n):
    for j in range(0,i):
        if array[j] < array[i]:
            #최대한 줄을 많이 세우는 것
            dp[i] = max(dp[i],dp[j]+1)

#열외해야 하는 병사의 최소 수를 출력
#최대한 많이 줄을 세웠으니 전체에서 빼면 열외된 숫자가 나오는 것
print(n-max(dp))