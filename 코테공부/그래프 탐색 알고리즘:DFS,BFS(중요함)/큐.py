from collections import deque

#큐 구현을 위해 deque 라이브러리 사용
#리스트를 사용해서 구현할 수도 있지만 시간 복잡도 측면에서 deque라이브러리를 쓰는 것이
#더 효율적이다
queue = deque()

#삽입(5) -삽입(2) -삽입(3) -삽입(7) -삭제() -삽입(1) -삽입(4) -삭제()
#큐에서의 append 함수는 리스트에서와 동일하게 동작함
#제일 마지막에 추가해줌
queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft()
queue.append(1)
queue.append(4)
queue.popleft()

print(queue)#먼저 들어온 순서대로 출력
queue.reverse()#역순으로 바꾸기
print(queue)#나중에 들어온 원소부터 출력