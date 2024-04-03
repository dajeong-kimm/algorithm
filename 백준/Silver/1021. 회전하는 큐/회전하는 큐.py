from collections import deque
n,m = map(int,input().split())
arr = list(map(int,input().split()))
queue = deque([i for i in range(1,n+1)])
count = 0
# print(queue.index(4))
for a in arr:
    while True:
        if queue[0] == a:
            queue.popleft()
            break
        else:
            if queue.index(a) < len(queue)/2:
                while queue[0] != a:
                    queue.append(queue.popleft())
                    count += 1
            else:
                while queue[0] != a:
                    queue.appendleft(queue.pop())
                    count += 1
print(count)