from collections import deque

def solution(priorities, location):
    answer = 0
    a = priorities[location]
    count = [0]*9
    
    for i in priorities: #location데이터보다 큰 값만 카운트 함
        if i>a:
            count[i-1] += 1
            
    priorities[location] = -1 #내가 찾을 값을 -1로 표시
    data = deque(priorities)
    
    result = sum(count) #자기보다 큰건 무조건 우선순위 높으니 다 합해줌
    i = 8
    while True:
        if i == a-1: #자기보다 큰게 없으면
            for x in data:
                if x == a:
                    answer += 1
                elif x == -1:
                    return result+answer+1 #큰거합 + 나보다 앞에있는 같은 값들의 합 + 현재위치
        if count[i] == 0 and i > a-1: #높은 우선순위부터 차례대로 찾아나감
            i -= 1
            continue
                
        num = data.popleft() #제일 앞에 문서를 꺼냄
        if num-1 < i: #해당 문서가 현재 가장 큰 값보다 작으면
            data.append(num) #뒤에 다시 추가함
        elif num-1 == i:
            if count[i]>0:
                count[i] -= 1