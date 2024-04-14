from collections import deque
n,w,l = map(int,input().split())
truck = list(map(int,input().split()))
queue = deque(truck)

bridge = deque([0 for _ in range(w)])

time = 0
tmp_w = 0
while queue:
    tmp_w -= bridge.popleft()
    if tmp_w +queue[0] <= l:
        tru = queue.popleft()
        bridge.append(tru)
        tmp_w += tru
    else:
        bridge.append(0)
    time += 1

time += w

print(time)