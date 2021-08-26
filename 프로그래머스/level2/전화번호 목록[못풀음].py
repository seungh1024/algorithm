def solution(phone_book):
    phone_book = sorted(phone_book)
    
    for i in range(len(phone_book)-1):
        if phone_book[i] ==  phone_book[i+1][:len(phone_book[i])]:
            return False
    return True

#사전순으로 정렬되니 바로 다음것만 비교하면 됐음
#그걸 모르고 전부 탐색하니 효율성에서 에러가 발생하는 것