def solution(phone_number):
    answer = ['*']*(len(phone_number)-4)
    for i in range(4):
        answer.append(phone_number[-4+i])
    return ''.join(answer)

# return ('*' * (len(phone_number)-4)) + answer[-4:] 로 한줄로 가능