def solution(n):
    d = [0] * n
    d[0] , d[1] = 1, 1 #1,2번째 수 초기화
    
    if n == 1 or n == 2:
        return d[n-1]
    
    for i in range(2,n):
        d[i] = d[i-1] + d[i-2]
        
    return d[-1]%1234567