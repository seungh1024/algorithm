from collections import defaultdict

def solution(lottos, win_nums):
    count = 0
    dict = defaultdict(bool)
    for i in lottos:
        if i == 0:
            count += 1 #0의 갯수
        dict[i] = True
            
    small = 0
    for i in win_nums:
        if dict[i]:
            small += 1
    
    if count == 0 and small == 0:
        return [6,6]
    
    if 6-small >= 5 :
        a = 6
    else:
        a = 7 - small
    
    return [7-(small+count),a]

    #순위를 리스트로 만들어서 반환 하면 좋았을듯 [6,6,5,4,3,2,1] 이렇게
    #인덱스별로 순위를 넣는 것
    #리스트의 count 함수를 사용해서 0의 개수를 세어도 좋았을 것 같다
    #set함수를 사용하여 중복을 찾는 것도 좋았을 것 같다