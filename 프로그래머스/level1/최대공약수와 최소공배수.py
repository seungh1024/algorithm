def solution(n, m):
    def gcd(a,b):
        if a % b == 0:
            return b
        return gcd(b,a%b)
    
    big = max(n,m)
    small = min(n,m)
    x = gcd(big,small) # 최대공약수
    y = big//x * small # 최소공배수
    
    return [x,y]

# 유클리드 호제법 이용
# 큰수에서 작은수를 나눠서 그 나머지를 이용하여
# 다시 작은수에서 나머지를 나누고
# 거기서 나온 나머지를 이용해서 다시 나누기를 반복
# 반복하다가 나머지가 0이되면 그게 최대공약수임
# 최소 공배수는 최대 공약수로 큰수를 나눈것에 작은수를 곱함