import sys
from collections import deque
input = sys.stdin.readline 
t = int(input().rstrip())
queue = deque()
for _ in range(t):
    inp = input().rstrip()
    if inp[:4]=="push":
        a,x = map(str,inp.split())
        queue.append(int(x))
    elif inp=="pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif inp=="size":
        print(len(queue))
    elif inp=="empty":
        if queue:
            print(0)
        else:
            print(1)
    elif inp=="front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    else:
        if queue:
            print(queue[-1])
        else:
            print(-1)
