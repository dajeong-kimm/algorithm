from collections import deque
import sys
input = sys.stdin.readline
t = int(input())
queue = deque()
for _ in range(t):
    com = input().rstrip()
    if com[:10]=="push_front":
        _,x = map(str,com.split())
        queue.appendleft(int(x))
    elif com[:9]=="push_back":
        _,x = map(str,com.split())
        queue.append(int(x))
    elif com=="pop_front":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif com=="pop_back":
        if queue:
            print(queue.pop())
        else:
            print(-1)
    elif com=="size":
        print(len(queue))
    elif com=="empty":
        if queue:
            print(0)
        else:
            print(1)
    elif com=="front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    else:
        if queue:
            print(queue[-1])
        else:
            print(-1)