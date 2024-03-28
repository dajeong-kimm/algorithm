from collections import deque
n = int(input())
student = list(map(int,input().split()))
student.sort()
queue = deque(student)
score = []
while queue:
    score.append(queue.popleft()+queue.pop())

print(min(score))