def solution(n):
    origin = n
    answer = 0
    data = ''
    check = 0 #자리바꿈하는 위치를 알기 위함
    num = 1
    a = 0
    count = 0
    while True:
        if n == 1: #모두 1인경우
            return (origin+1)//2 + origin
        if n%2 == 0 and check == 1:
            break
        if n%2 == 1:
            a += num
            check = 1
            count += 1 #이동해야하는 1의 개수를 셈
        num *= 2
        n = n//2
        
    origin -= a #원래 a만큼 빼줌
    origin += num #자리바뀐 1을 더해줌
    k = 1
    for i in range(1,count): #밀린 1만큼 더해줌
        origin += 1*k
        k *= 2

    
    return origin