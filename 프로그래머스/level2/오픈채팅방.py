def solution(record):
    answer = []
    dict = {} #아이디에 해당하는 닉네임 값을 담아줌
    data = [] #동작하는 정보를 담아줌
    
    for i in record:
        if len(i.split()) == 3:
            a,b,c = i.split()
            dict[b] = c #아이디에 해당하는 닉네임 값
            data.append((a,b)) # 행동 A와 해당하는 아이디 B를 넣어줌
            #여기서 change는 상관없는게 앞에 어떤 값이 오든 아이디와 닉네임 값을 주기 때문
        else:
            a,b = i.split()
            data.append((a,b)) # Leave는 행동과 아이디만 있으므로 data에 추가
            
    for a,b in data:
        if a == 'Enter':
            answer.append(dict[b]+'님이 들어왔습니다.')
        elif a == 'Change':
            continue
        else:
            answer.append(dict[b]+'님이 나갔습니다.')
        
    return answer

