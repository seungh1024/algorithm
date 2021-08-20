def solution(num):
    for i in range(501):
        if num == 1:
            return i
        if num % 2 == 0:
            num /= 2
        else:
            num = num*3 + 1
        
    
    return -1