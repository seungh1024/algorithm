def solution(absolutes, signs):
    answer = 0
    for i in range(len(signs)):
        if not signs[i]:
            # count += absolutes[i]
            answer -=absolutes[i]
        else:
            answer += absolutes[i]
    return answer