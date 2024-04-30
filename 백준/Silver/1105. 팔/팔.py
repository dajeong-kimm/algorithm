from collections import deque
a,b = map(str,input().split())
a = list(a)
b = list(b)
queue_a = deque(a)
queue_b = deque(b)
answer = 0
len_a = len(a)
len_b = len(b)
if len_a<len_b:
    # for _ in range(len_b-len_a):
    #     queue_a.appendleft("0")
    print(0)
    exit()

for i in range(len_b):
    if queue_a[i] == queue_b[i]:
        if queue_a[i] == "8":
            answer += 1
    else:
        break

print(answer)

