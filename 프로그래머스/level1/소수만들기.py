from itertools import combinations
import math

def solution(nums):
    answer = 0
    result = list(combinations(nums,3))
    data = [True]*(1000+999+998+1)
    def fun(num):
        for i in range(2,int(math.sqrt(num)+1)):
            if data[i] == True: 
                j = 2
                while i*j <= num:
                    data[i*j] = False
                    j += 1
    fun(len(data)-1)
    print(data)
    for a,b,c in result:
        if data[a+b+c]:
            answer +=1
    

    return answer