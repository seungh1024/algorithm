def solution(progresses, speeds):
    answer = []
    result = []
    for a,b in zip(progresses,speeds):
        x = (100-a)//b #걸리는 시간
        y = (100-a)%b #나머지 남으면 하루 더 걸려서 체크하기 위함
        if y != 0:
            result.append(x+1)
        else:
            result.append(x) #나누어 떨어지면 그냥 추가해줌
    print(result)
    count = 1
    a = result[0]
    for i in range(1,len(result)):
        if a >= result[i]:
            count += 1
        else:
            answer.append(count)
            count = 1
            a = result[i]
    answer.append(count)
    return answer