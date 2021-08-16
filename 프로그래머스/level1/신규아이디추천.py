def solution(new_id):
    answer = ['.']
    a = '.!A.!'
    print(a[len(a)-1])
    print(a.lower())
    print(ord('a')) #97
    print(ord('z')) #122
    print(ord('0')) #48
    print(ord('9')) #57
    new_id = list(new_id.lower()) #1단계
    i = 0
    print(a)

    # ..을 .으로 바꾸는건 replace를 사용했어도 좋았을 것 같다
    # 탐색 한 번에 최대한 해결하려다 보니 이렇게 된 것 같다
    while len(answer) <= 15 and i < len(new_id): # 2,3단계 + 6단계 길이15제한
        if 97<=ord(new_id[i])<=122 or 48<=ord(new_id[i])<=57 or new_id[i] == '-' or new_id[i] == '_' :
            answer.append(new_id[i])
        elif new_id[i] == '.':
            if answer[-1] != '.':
                answer.append(new_id[i])
        i += 1
                
    answer.remove('.')
    if answer == []: #5단계
        answer.append('a')
    if answer[-1]  == '.': #6단계 '.'제거
        answer.pop()
    if len(answer) <= 2: #7단계
        while len(answer) <3:
            answer.append(answer[-1])
        
    result = ''
    for i in answer:
        result += i
    return result