from collections import deque
n = int(input())

queue = deque([(i+1) for i in range(n)])
answer = []
while len(queue)>1:
    answer.append(queue.popleft())
    queue.append(queue.popleft())
answer.append(queue[0])
print(*answer)