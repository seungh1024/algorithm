from itertools import permutations
import math

def fun(num):
    for i in range(2,int(math.sqrt(num))+1): #제곱근 까지 탐색하며
        if num % i == 0:
            return False #소수 아님
    return True #소수임

def solution(numbers):
    answer = 0
    numbers = list(numbers)
    case = [] #순열로 모든 경우를 넣음
    for i in range(1,len(numbers)+1):
        case += list(permutations(numbers,i))
    
    result = [] #모든 경우를 정수화 해서 담아줌
    for i in case:
        a = ''
        for j in range(len(i)):
            a += i[j]
        result.append(int(a))
        
    result = set(result)
    
    for i in result: #각 수가 소수인지 판별
        if i != 0 and i != 1:
            if fun(i):
                answer += 1
    return answer