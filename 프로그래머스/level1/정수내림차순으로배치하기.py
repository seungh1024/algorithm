def solution(n):
    a = list(str(n))
    a.sort(reverse = True)
    
    answer = ''
    for i in a:
        answer += str(i)
    
    return int(answer)

# return 에 int(''.join(answer)) 을 해도 됨
# join함수가 바로 문자열로 합쳐줌