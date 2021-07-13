N,K = map(int,input().split())
count = 0

while(N != 1):
    if(N%K != 0):
        N -= 1
        count +=1
    else:
        N = N//K
        count +=1
print(count)

#가능하면 최대한 많이 나누는 작업이 최적의 해를 보장할 수 있을까?
#N이 아무리 큰 수여도 K로 나누면 기하급수적으로 빠르게 줄일 수 있기 때문에 보장가능함
#K가 2이상이기만 하면 K로 나누는 것이 1을 빼는 것 보다 항상 빠르게 N을 줄일 수 있음
#또한 N은 항상 1에 도달하게 됨

#모범 답안
n,k = map(int, input().split())

result = 0 #게수를 세기 위한 변수

while True:
    target = (n // k) * k #가장 먼저 나누어 떨어지는 수를 구함
    result += (n - target) #입력값 n에서 제일 처음 나누어 떨어지는 수를 뺌
    #이렇게 뺀 값은 마이너스 연산을 하는 횟수가 되는 것
    n = target
    if n < k:
        break

    result +=1
    n //= k #나누기 연산을

#남은 수가 1보다 크면 해당 수만큼 뺀 연산을 더해주는 것
result += (n-1)
print(result)

##모범 답안은 시간 복잡도가 적게 나옴
#코드가 빨리 실행되기 때문 로그 시간 복잡도가 나옴
#매우 큰 수가 입력되었을 때 내 모범 답안이 시간 제한에서 매우 유리함