from collections import deque
n, k = map(int,input().split())
queue = deque([i for i in range(1,n+1)])

answer = []
while queue:
    for i in range(k-1):
        tmp = queue.popleft()
        queue.append(tmp)
    answer.append(str(queue.popleft()))


answer = ', '.join(answer)
print(f"<{answer}>")
