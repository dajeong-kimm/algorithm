from collections import deque

n,m,r = map(int,input().split())

matrix = []
answer = [[0]*m for _ in range(n)]
queue = deque()

for i in range(n):
    matrix.append(list(map(int,input().split())))

loops = min(n,m)//2

for i in range(loops):
    queue.clear()
    queue.extend(matrix[i][i:m-i])
    queue.extend([row[m-i-1] for row in matrix[i+1:n-i-1]])
    queue.extend(matrix[n-i-1][i:m-i][::-1])
    queue.extend([row[i] for row in matrix[i+1:n-i-1]][::-1])

    queue.rotate(-r)

    for j in range(i,m-i):
        answer[i][j] = queue.popleft()
    for j in range(i+1,n-i-1):
        answer[j][m-i-1] = queue.popleft()
    for j in range(m-i-1,i-1,-1):
        answer[n-i-1][j] = queue.popleft()
    for j in range(n-i-2,i,-1):
        answer[j][i] = queue.popleft()

for line in answer:
    print(*line)