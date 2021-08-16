def solution(a, b):
    answer = list(map(lambda i,j:i*j,a,b))
    
    return sum(answer)