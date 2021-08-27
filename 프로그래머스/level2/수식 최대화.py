from collections import deque

def solution(expression):
    answer = 0
    data = []
    a = ''
    
    for i in expression:
        if i == '-' or i == '+' or i == '*':
            data.append(int(a))
            data.append(i)
            a = ''
        else:
            a += i
    data.append(int(a)) #마지막 값은 조건문에 부합하지 않아 따로 추가
    
    def fun(x,y,z): #
        case = deque(data) #데이터를 큐로 초기화 시켜줌
        arr = [x,y,z] #기호값을 담음
        print(arr)
        for i in range(3): #우선순위별로 총 세번 실행
            length = len(case)
            j = 0
            while j < length: #한바퀴마다 실행
                j+=1 # 매 실행마다 카운팅 -> popleft는 무조건 하므로
                num1 = case.popleft()
                if num1 == arr[i]: #연산기호 만나면
                    if num1 == '-':
                        k = case.pop() - case.popleft() #이전의 숫자와 기호 다음 숫자 연산을 수행
                        case.append(k) #맨뒤로 들어감
                    elif num1 == '+':
                        k = case.pop() + case.popleft()
                        case.append(k) #맨뒤로 들어감
                    elif num1 == '*':
                        k = case.pop() * case.popleft()
                        case.append(k) #맨뒤로 들어감
                    j += 1 #기호를 만나면 바로 뒤의 값도 같이 나와서 계산하므로 2를 더해줌
                    
                else:
                    case.append(num1)
                    
        return int(case[0]) #최종값을 리턴해줌
    
    return max(abs(fun('-','*','+')),abs(fun('-','+','*')),abs(fun('+','*','-')),abs(fun('+','-','*')),abs(fun('*','+','-')),abs(fun('*','-','+')))

# eval 이라는 함수가 있는데 어떤 식이 문자열로 매개변수로 들어오면 해당
# 문자열을 식으로 실행해주는 함수이다.
# 나는 이걸 몰라서 예외처리를 전부 해주었지만 이걸 썼으면 편리했을 것 같다
# eval('1+2')를 하면 3이 반환된다