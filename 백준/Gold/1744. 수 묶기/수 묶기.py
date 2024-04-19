from collections import deque
n = int(input())
arr = [int(input()) for _ in range(n)]
arr.sort()
defualt_sum = sum(arr)
queue = deque(arr)
answer = 0
while len(queue)>=2:
    tmp1 = queue[0]*queue[1]
    tmp2 = queue[-1]*queue[-2]
    tmp3 = queue[-1]*queue[0]
    if tmp3>=tmp1 and tmp3>=tmp2:
        a = queue.popleft()
        b = queue.pop()
    elif tmp1>=tmp2:
        a = queue.popleft()
        b = queue.popleft()
    else:
        a = queue.pop()
        b = queue.pop()
    if a*b>=a+b:
        answer += a*b
    else:
        answer += a+b

if queue:
    answer += queue[0]
print(answer)

    
    