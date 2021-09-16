import math

def solution(arr):
    def lcm(a,b): #두 수의 곱을 두 수의 최대공약수로 나누면 최소공배수임
        return a*b // math.gcd(a,b)
    
    for i in range(1,len(arr)): #2개씩 전부 진행하면 마지막 원소가 답이됨
        arr[i] = lcm(arr[i],arr[i-1])
    
        
    return arr[-1]