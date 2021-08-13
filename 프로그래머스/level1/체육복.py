def solution(n, lost, reserve):
    from collections import defaultdict
    
    answer = 0
    check = defaultdict(bool)
    lost.sort()
    
    for i in reserve:
        check[i] = True
   
    data = []
    for i in lost:
        if check[i]:
            check[i] = False
        else:
            data.append(i)
    
    for i in data:
        if check[i-1]:
            check[i-1] = False
        elif check[i+1]: 
            check[i+1] = False
        else:
            answer += 1
    
    return n-answer