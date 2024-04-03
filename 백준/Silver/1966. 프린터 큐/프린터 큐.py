from collections import deque
t = int(input())

for _ in range(t):
    a,b = map(int,input().split())
    arr = list(map(int,input().split()))
    queue = deque(arr)
    count = 0
    while queue:
        max_value = max(queue)
        tmp = queue.popleft()
        b -= 1
        if b<0:
            if max_value == tmp:
                count += 1
                answer = count
                break
            else:
                queue.append(tmp)
                b = len(queue)-1

        else:
            if max_value>tmp:
                queue.append(tmp)
            else:
                count += 1
    print(answer)
            
        