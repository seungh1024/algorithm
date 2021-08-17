def solution(price, money, count):
    b = count // 2
    if count % 2 == 0:
        return max(0,price* (count + 1) * b - money)
    else:
        return max(0,price *((count + 1) * b + b+1) - money)
    