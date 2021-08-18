def solution(n):
    answer = 0
    
    for i in range(1,n//2 +1):
        if n % i == 0:
            answer += i
    
    return answer+n

# 약수이므로 2로 나눈수 까지만 구하면 됨 후에 자기자신을 더하면 됨