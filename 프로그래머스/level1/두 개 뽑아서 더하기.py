from itertools import combinations

def solution(numbers):
    answer = []
    data = list(combinations(numbers,2))
    print(data)
    for a,b in data:
        answer.append(a+b)
        
    return sorted(list(set(answer)))