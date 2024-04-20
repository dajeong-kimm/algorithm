n = int(input())
arr = list(map(int,input().split()))
stack = []
queue = []
for i in range(n):
    for _ in range(arr[i]):
        stack.append(queue.pop())
    queue.append(i+1)
    while stack:
        queue.append(stack.pop())

print(*queue)