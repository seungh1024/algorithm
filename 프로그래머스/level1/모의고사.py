def solution(answers):
    answer = {1:0,2:0,3:0}
    lenans = len(answers)
    num1 = [1,2,3,4,5]*(lenans//5+1)
    num2 = [2,1,2,3,2,4,2,5]*(lenans//8 +1)
    num3 = [3,3,1,1,2,2,4,4,5,5]*(lenans//10 +1)
    
    for i in range(lenans):
        if num1[i] == answers[i]:
            answer[1] += 1
        if num2[i] == answers[i]:
            answer[2] += 1
        if num3[i] == answers[i]:
            answer[3] += 1
            
    result = []
    a = max(answer.values())
    for key,value in answer.items():
        if a == value:
            result.append(key)
    
    return result