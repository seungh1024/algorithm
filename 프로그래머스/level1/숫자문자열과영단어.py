def solution(s):
    dict = {'zero':'0','one':'1','two':'2','three':'3','four':'4','five':'5','six':'6','seven':'7','eight':'8','nine':'9'}
    answer = ''
    a = ''
    for i in s:
        if ord(i) <= 57:
            answer += i
        else:
            a += i
        if a in dict:
            answer += dict[a]
            a = ''
    return int(answer)


    # replace 함수
    # replace('찾을값','바꿀값','바꿀횟수')
    # replace('찾을값','바꿀값')으로 해도 됨 횟수 안적으면 전부 바꿈