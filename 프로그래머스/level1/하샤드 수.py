def solution(x):
    def fun(n):
        if n < 10: #10보다 작아서 안나누어지면 그 수를 리턴
            return n
        return fun(n//10) + n%10 #재귀호출로 10으로나눈 나머지와 못나누는 수까지 모두 더함
    
    if x % fun(x) == 0: #나누어 떨어지면 true 리턴
        return True
    return False