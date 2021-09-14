def solution(people, limit):
    answer = 0
    left = 0
    right = len(people)-1
    people.sort()
    
    while True:
        if left == right: #길이가 홀수인 경우
            return answer+1 #해당 값을 카운트 해줘야 하므로 +1
        elif left > right: #길이가 짝수인 경우
            return answer #모든 인덱스를 방문했으니 answer리턴
        
        if people[right] + people[left] > limit: 
            #limit보다 합이 큰경우
            right -= 1 #큰 쪽의 인덱스가 줄어듦 -> 한명만 탐
            answer += 1 
        elif people[right] + people[left] <= limit:
            #limit과 같거나 작은 경우
            right -= 1
            left += 1 #둘 다 인덱스 값이 변함
            answer += 1
        
#처음에 사전자료형으로 개수를 세서 해결하려 했지만 효율이 안좋을 것 같았음
#투포인터로 정렬하여 양쪽에서 조여오는 형식으로 해결함