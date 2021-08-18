def solution(seoul):
    answer = ''
    for idx , kim in enumerate(seoul):
        if kim == 'Kim':
            return "김서방은 " + str(idx) + "에 있다"

# enumerate 말고 값으로 인덱스를 찾으려면
# seoul.index('Kim') 이라고 하면 인덱스가 나온다