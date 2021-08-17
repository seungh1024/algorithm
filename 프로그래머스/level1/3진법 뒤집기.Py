def solution(n):
    answer = 0
    
    def fun(n,k): #n은 몫, k는 나머지
        if n <3:
            return str(n)
        return fun(n//3,n%3) + str(n%3) #반전하지않고 문자열로 합침
    
    result = fun(n,0)
    
    j = 1
    for i in result: #앞에서부터 0이 나오기 전까지 10진법으로 변환해서 더해줌
        if i == 0:
            break
        answer += int(i)*j
        j *= 3
    
    return answer