def solution(a, b):
    answer = 0
    k = a+b
    x = max(a,b) - min(a,b)+1
    if x %2 >0:
        return k *(x//2) + k//2
    return k * (x//2)

# 절댓값 함수를 몰라서 max와 min 이용
# 절댓값 함수는 abs()를 사용하면 됨