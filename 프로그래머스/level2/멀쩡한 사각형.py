def solution(w,h):
    # y = h/w * x
    answer = 0
    if w == h:
        return w*h - w
    elif w == 1 or h == 1:
        return 0
    
    for i in range(1,w):
        answer += int((h*i)/w) #기울기에서 x좌표값을 넣어서 계산하니 테스트 6에서 오류 발생
        #소수점을 만들고 곱하는 연산이 부정확할 수 있다고 함
        #그러니 이런 경우에는 곱하기를 먼저하고 나누기를 하는게 정확함
    return 2*answer

# def gcd(a,b): return b if (a==0) else gcd(b%a,a)    
# def solution(w,h): return w*h-w-h+gcd(w,h)
# 나처럼 풀면 안되고 이렇게 최대공약수를 이용해야 했음
# w와 h만큼 빼고 중복되는 것 만큼 더해줬음 이게 최대공약수만큼임
# 난 최대공약수를 이용하려 했지만 그걸 이용한 규칙을 찾지못해 하나하나 더했음