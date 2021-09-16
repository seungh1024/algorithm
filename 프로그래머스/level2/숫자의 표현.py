def solution(n):
    answer = 0
    left = 1
    right = 1
    count = 0
    while right < n//2 + 1:
        if count == n:
            answer += 1
            count -= left
            left += 1
        elif count > n:
            count -= left
            left += 1
        else:
            count += right
            right += 1
    
    if n == (n//2)*2 + 1: #예외처리 -> right가 n//2가 되면 반복문 탈출하기 때문
        answer += 1
        
    return answer + 1 #자기자신
