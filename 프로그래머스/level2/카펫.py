import math

def solution(brown, yellow):
    num = []
    for i in range(1,int(math.sqrt(yellow))+1): #약수를 찾아서 넣음
        if yellow % i == 0:
            num.append(i)
            
    b = yellow
    index = 0
    while True:
        if (yellow+2) * (num[index]+2) -b == brown:
            return [yellow+2,num[index]+2]
        else:
            index += 1
            yellow = b//num[index]