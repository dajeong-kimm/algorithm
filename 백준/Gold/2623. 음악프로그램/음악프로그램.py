from collections import deque
n,m = map(int,input().split())
inDegree = [0 for _ in range(n+1)]
graph = [[] for _ in range(n+1)]
answer = []
for _ in range(m):
    tmp = list(map(int,input().split()))
    order = deque(tmp)
    order.popleft()
    if len(order)>1:
        a = order.popleft()
        b = order.popleft()
        graph[a].append(b)
        inDegree[b] += 1
        while order:
            a = b
            b = order.popleft()
            graph[a].append(b)
            inDegree[b] += 1

def make_degree():
    if inDegree[1:].count(0) == 0:
        for i in range(1,n+1):
            inDegree[i] -= 1
make_degree()
def order_sort():
    global answer
    queue = deque()
    for i in range(1,n+1):
        if inDegree[i] == 0:
            queue.append(i)
    
    while queue:
        x = queue.popleft()
        answer.append(x)
        for j in graph[x]:
            inDegree[j] -= 1
            if inDegree[j] == 0:
                queue.append(j)

order_sort()
if len(answer) != n:
    print(0)
else:
    for a in answer:
        print(a)