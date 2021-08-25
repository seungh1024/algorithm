from itertools import combinations
from collections import defaultdict

def solution(orders, course):
    
    kind = defaultdict(list) #개수별로 담은 메뉴
    answer = []
    
    for i in course: #조합 할 수 있는 것들 별로
        menu = defaultdict(int) #메뉴 개수를 세는 사전자료형
        case = [] #대소비교를 위한 리스트
        for order in orders:
            data = list(combinations(sorted(order),i)) #코스별로 조합한걸 data에 넣음
            
            for j in data:
                a = ''.join(j) #조합으로 뽑은 각 메뉴들을 하나로 합쳐줌 -> 하나의 코스
                menu[a] += 1 #해당 코스가 몇개인지 카운트
                if menu[a] >= 2: #최소 2개이상이므로 2개이상이면 case에 추가
                    case.append((menu[a],a)) #개수의 메뉴추가
                    
        k = 0
        for a,b in sorted(case,reverse = True): #메뉴를 정렬하여 가장 큰것만 뽑아냄
            if a>=k:
                k = a
                answer.append(b)
        
    
    return sorted(answer)