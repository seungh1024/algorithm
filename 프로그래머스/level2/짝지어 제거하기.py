def solution(s):
    data = list(map(str,s))
    
    answer = [-1] #첫 비교를 위해 -1을 넣었음
    for i in data:
        if answer[-1] != i:
            answer.append(i) #마지막 값과 다르면 현재값 추가
        else:
            answer.pop() #같으면 answer의 마지막값 pop
            
    if len(answer) <=1:
        return len(answer) #전부 제거되면 -1때문에 길이가 1임
    return 0 #아니면 0반환