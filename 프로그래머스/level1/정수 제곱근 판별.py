def solution(n):
    a = n**0.5
    if a == int(a):
        return (int(a)+1)**2
    return -1

# 형변환 말고 나머지 연산으로 1을 나눠서 0이면 리턴하는게 좋았을듯