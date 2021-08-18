def solution(s):
    a = ''
    for i in sorted(s,reverse = True):
        a += i
    return a

# return ''.join(sorted(s,reverse = True)) 를 사용하는게 더 좋을듯
# 반복문을 돌리지 않고 join으로 바로 빈 문자열에 합쳐줘서 리턴함
# 문자열.join(문자열리스트)