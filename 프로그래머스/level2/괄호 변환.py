def solution(p):
    answer = ''
    if not p:
        return ""
    dict = {'(':')',')':'('}
    count = 0 # '(' 의 개수를 셈
    error = 0 # '(' 의 개수가 항상 더 많지 않았다면 1로 바꿔주는 변수
    result = ''
    for index,value in enumerate(p):
        if count < 0:
            error = 1
        if value == '(':
            count += 1
        elif value == ')':
            count -= 1
        result += value
        
        if count == 0:
            if error == 0: #올바른 괄호 문자열
                answer += result +solution(p[index+1:])
                print('ok:',answer)
                break
            else: #균형잡힌 문자열, 올바르지 않음
                # answer += solution(result)
                data = ''
                for k in range(1,len(result)-1):
                    data += dict[result[k]]
                answer += '('+solution(p[index+1:])+')'+data
                print('data:',data)
                print(answer)
                break
                    
    return answer