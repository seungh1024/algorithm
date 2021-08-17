def solution(n):
    import math
    
    answer = [True] * (n+1)
    answer[0] = False
    answer[1] = False
    
    for i in range(2,int(math.sqrt(n))+1):
        j = 2
        while i*j<=n:
            answer[i*j] = False
            j +=1
    
    count = 0
    
    for i in answer:
        if i == True:
            count += 1
    
    return count