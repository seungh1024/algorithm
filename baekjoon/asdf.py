import math

def univ(k):
    z=int(k)+1
    v=math.sqrt(z**2-z)
    if(k==int(k)):
        print((2*int(k))-1)
    elif(k>int(k) and k<=v):
        print(2*int(k))
    else:
        print(2*int(k)+1)

T=input()
T=int (T)
for i in range (0,T):
    x,y=input().split(" ")
    k=math.sqrt(int(y)-int(x))
    if(int(y)-int(x)>2 and int(y)-int(x)<=4):
        print(3)
    elif(int(y)-int(x)==2):
        print(2)
    else:
        univ(k)
    
    


'''
1:1
1 1: 2
1 1 1: 3
1 2 1:4         2제곱 ->3개
1 2 1 1:5
1 2 2 1:6
1 2 2 1 1:7             4개
1 2 2 2 1:8
1 2 3 2 1:9         3제곱 ->5개
1 2 3 2 1 1:10
1 2 3 2 2 1:11
1 2 3 3 2 1:12
1 2 3 3 2 1 1:13
1 2 3 3 2 2 1:14
1 2 3 3 3 2 1:15
1 2 3 4 3 2 1:16  4제곱
1 2 3 4 3 2 1 1:17
1 2 3 4 3 2 2 1: 18
1 2 3 4 3 3 2 1: 19
1 2 3 4 4 3 2 1: 20
1 2 3 4 4 3 2 1 1: 21
1 2 3 4 4 3 2 2 1: 22
1 2 3 4 4 3 3 2 1: 23
1 2 3 4 4 4 3 2 1: 24
1 2 3 4 5 4 3 2 1: 25 5제곱
1 2 3 4 5 4 3 2 1 1:26
1 2 3 4 5 4 3 2 2 1:27
1 2 3 4 5 4 3 3 2 1:28
1 2 3 4 5 4 4 3 2 1:29
1 2 3 4 5 5 4 3 2 1:30
1 2 3 4 5 5 4 3 2 1 1:31
1 2 3 4 5 5 4 3 2 2 1:32
1 2 3 4 5 5 4 3 3 2 1:33
1 2 3 4 5 5 4 4 3 2 1:34
1 2 3 4 5 5 5 4 3 2 1:35
1 2 3 4 5 6 5 4 3 2 1:36 6제곱
'''