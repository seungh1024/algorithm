def solution(d, budget):
    d.sort()
    d.append(10000001)
    answer = 0
    for i in range(len(d)):
        answer += d[i]
        if answer > budget:
            return i