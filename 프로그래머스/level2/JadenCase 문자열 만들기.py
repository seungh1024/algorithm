def solution(s):
    answer = ''
    s = s.lower()
    check = 1
    for i in s:
        if check == 1:
            i = i.upper()
            answer += i
            check = 0
        else:
            answer += i
        
        if i == ' ':
            check = 1
    
    return answer