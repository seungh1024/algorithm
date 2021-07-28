s = str(input())
test = str(input())

def fun(s,t):
    a =sorted(s) #sorted 함수 기억할 것
    b =sorted(t)
    for i in range(len(s)):
        if a[i] != b[i]:
            return False
    return True

print(fun(s,test))