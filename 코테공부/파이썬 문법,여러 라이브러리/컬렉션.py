from collections import Counter

counter = Counter(['red','blue','red','green''blue','blue'])

print(counter['blue'])#blue 등장한 횟수 출력
print(counter['green'])#green 등장한 횟수 출력
print(dict(counter))#사전 자료형으로 반환