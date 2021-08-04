#소수 판별 함수(2이상의 자연수에 대하여)
def is_prime_number(x):
    #2부터 (x-1)까지의 모든 수를 확인하며
    for i in range(2,x):
        #x가 해당 수로 나누어 떨어진다면
        if x % i == 0:
            return False #소수가 아님
    return True #소수임

print(is_prime_number(4))
print(is_prime_number(7))

#2부터 x-1까지 모든 자연수에 대하여 연산 수행해야 함
#->모든 수를 하나씩 확인한다는 점에서 시간 복잡도는 O(X)임