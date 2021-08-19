def solution(x, n):
    answer = []
    k = x
    for i in range(n):
        answer.append(x)
        x+=k
    return answer