import heapq
INF = int(1e9)
def dijkstra(start,end):
    distance = [INF]*(n+1)
    heap = []
    distance[start] = 0
    heapq.heappush(heap,[0,start])
    while heap:
        dist,now = heapq.heappop(heap)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost<distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(heap,[cost,i[0]])
    return distance[end]


n,e = map(int,input().split())


graph = [[] for _ in range(n+1)]

for _ in range(e):
    a,b,c = map(int,input().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

A,B = map(int,input().split())

path1 = dijkstra(1,A) + dijkstra(A,B) + dijkstra(B,n)
path2 = dijkstra(1,B) + dijkstra(B,A) + dijkstra(A,n)

if path1>=INF and path2>=INF:
    print(-1)
else:
    print(min(path1,path2))