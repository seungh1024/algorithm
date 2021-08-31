from itertools import combinations_with_replacement,product

def solution(word):
    answer = 0
    case = ['A','E','I','O','U']
    result = []
            
    for i in range(1,6):
        result += (list(product(case,repeat = i)))
        
    result.sort()
    # print(len(result))
    data = tuple(list(word))
    # print(data)
    # print(result.index(data))
    return result.index(data) + 1