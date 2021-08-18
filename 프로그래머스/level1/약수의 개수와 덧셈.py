import math

def solution(left, right):
    answer = 0
    
    for i in range(left,right+1):
        if math.sqrt(i) - int(math.sqrt(i)) == 0:
            answer -= i
        else:
            answer += i
    return answer