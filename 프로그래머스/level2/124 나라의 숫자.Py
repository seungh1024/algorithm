def solution(n):
    answer = ''
    while True:
        if n == 0:
            break
        n = n-1
        k = n%3
        if k == 0:
            answer ='1'+answer
        elif k == 1:
            answer ='2'+answer
        else:
            answer ='4'+answer
        
        n = n//3
        
    return answer

# 규칙을 잘 찾아야함
# 3진법처럼 보이지만 그렇게 하면 0을 처리하지 못해서 안됨
# 1을 뺴고 나머지 계산을 하는 방식을 사용해야 함