def solution(scores):
    answer = ''
    score = 0
    for i in range(len(scores)):
        score = []
        print(sum(score))
        for j in range(len(scores)):
            if i != j:
                       score.append(scores[j][i])
        if scores[i][i] > max(score) or scores[i][i] < min(score):
                x = sum(score)/(len(score))
        else:
                x = int(sum(score)+scores[i][i])/(len(scores))
        
        if x >= 90:
                       answer += 'A'
        elif x >=80:
                       answer += 'B'
        elif x >= 70:
                       answer += 'C'
        elif x >= 50:
                       answer += 'D'
        else:
                       answer += 'F'
                       
    # print(len(scores));        
    return answer