S = input()
S = list(S)
S.sort(reverse = True)
result = int(S[0])

for i in range(1,len(S)):
    if(S[i] == '0'):
        break
    if(S[i] != '1'):
        result *= int(S[i])
    else:
        result +=1

print(result)

#문제 해결 아이디어
#대부분의 경우 '+' 보다는 'x'가 더 값을 크게 만든다.
# ->예를 들어 5+6 =11 이고 5*6 = 30이다
#다만 두 수 중에서 하나라도 '0'혹은 '1'인 경우 곱하기보다는 더하기를 수행하는 것이 효율적
#따라서 두 수에 대하여 연산을 수행할 때, 두 수 중에서 하나라도 1 이하인 경우에는 더하며,
#두 수가 모두 2 이상인 경우에는 곱하면 정답임

#모범 답안
data = input()

#첫 번째 문자를 숫자로 변경하여 대입
result = int(data[0])

for i in range(1,len(data)):
    num = int(data[i])
    if num <=1 or result <= 1: #0또는 1이면 더하고
        result +=num
    else: #아니면 곱합
        result *= num
print(result)