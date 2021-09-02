def solution(n,a,b):
    answer = 0
    
    while True:
        if a == b:
            return answer
        a = (a+1)//2
        b = (b+1)//2
        answer+=1