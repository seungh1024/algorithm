S = list(input())
S.sort()

string = ''
num = 0

for i in S:
    if ord(i)>=65:
        string += i
    else:
        num += int(i)
if(num != 0):
    string = string + str(num)

print(string)

#모범답안
#문제 해결 아이디어
#-요구사항대로 충실히 구현하면 되는 문제
#-문자열이 입력되었을 때 문자를 하나씩 확인한다
#   ->숫자인 경우 따로 합계를 계산함
#   ->알파벳은 경우 별도의 리스트에 저장
#-결과적으로 리스트에 저장된 알파벳을 정렬해 출력하고, 합계를 뒤에 붙여 출력하면 정답

data = input()
result = []
value = 0

#문자를 하나씩 확인하며
for x in data:
    #알파벳인 경우 결과 리스트에 삽입
    if x.isalpha():
        #isalpha() -> 문자열의 구성이 알파벳인지에 대해서 확인하는 방법
        #문자열에 숫자 및 공백이 포함되어 있으면 False를 리턴하니 주의가 필요함
        #숫자인지 확인하는 것으로는 isdigit()이 있음
        result.append(x)
    #숫자는 따로 더하기
    else:
        value += int(x)

#알파벳을 오름차순으로 정렬
result.sort()

#숫자가 하나라도 존재하는 경우 가장 뒤에 삽입
if value != 0:
    result.append(str(value))

#최종 결과 출력(리스트를 문자열로 변환하여 출력)
print(''.join(result))