from collections import deque

n = int(input())

building = [[] for _ in range(n+1)]

inDegree = [0]*(n+1)
cost = [0]*(n+1)

for i in range(1,n+1):
    data = list(map(int,input().split()))[:-1]
    cost[i] = data[0]
    building_data = data[1:]

    for j in building_data:
        building[j].append(i)
        inDegree[i] += 1

def topology_sort():
    result = [0]*(n+1)
    queue = deque()

    for i in range(1,n+1):
        if inDegree[i] == 0:
            queue.append(i)
    
    while queue:
        now = queue.popleft()
        result[now] += cost[now]
        
        for b in building[now]:
            inDegree[b] -= 1
            result[b] = max(result[b],result[now])
            if inDegree[b] == 0:
                queue.append(b)
    return result

answer = topology_sort()

for i in range(1,n+1):
    print(answer[i])