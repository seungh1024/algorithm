def solution(s):
    answer = []
    num = ['0','1','2','3','4','5','6','7','8','9']
    data = []
    a = []
    b = ''
    
    for i in s:
        if i == '}':
            if b != '':
                a.append(int(b))
            data.append(a)
            a = []
            b = ''
        elif i == ',':
            if b != '':
                a.append(int(b))
            b = ''
        elif i in num:
            b += i
    data.remove([])
    data = sorted(data,key = lambda x: len(x))
    answer.append(data[0][0])
    
    for i in data:
        for k in i:
            if k not in answer:
                answer.append(k)
        
            
    return answer

#시간복잡도가 많이 나와서 다른 사람들의 아이디어를 보고 다시 작성
#개수가 제일 많은게 제일 앞에 나오는 것
#사전자료형을 써서 시간을 줄였지만 드라마틱한 결과는 나오지 않았음
#두배이상은 빨라졌음
#그냥 리스트에 담고 Counter를 사용하는게 더 빨랐을 것 같다
from collections import defaultdict

def solution(s):
    answer = []
    data = defaultdict(tuple)
    num = ['0','1','2','3','4','5','6','7','8','9']
    b = ''
    for i in s:
        if i == '}' or i == ',':
            if b != '':
                a = int(b) 
                if data[a]:
                    data[a] =(data[a][0]+1,a)
                else:
                    data[a] = (1,a)
            b = ''
        elif i in num:
            b += i
            
    for x,y in sorted(data.values(),reverse = True):
        answer.append(y)
    
    return answer