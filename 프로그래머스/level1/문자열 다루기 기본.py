def solution(s):
    if (len(s) == 4 or len(s) == 6) and ord(sorted(s)[-1]) <=57:
        return True
    return False
n = 'a1b2c3'
print(n.isdigit())
k = '1234'
print(k.isdigit())
# 문자인지 확인하기위해 .digit() 사용을 하면 좋았을듯
# 문자열.isdigit() 을 하면 모두 숫자면 True, 문자가 섞이면 False 반환