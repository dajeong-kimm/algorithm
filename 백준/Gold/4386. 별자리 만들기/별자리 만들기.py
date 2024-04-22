def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union(x,y):
    x = find_parent(x)
    y = find_parent(y)
    if x<y:
        parent[y] = x
    else:
        parent[x] = y

n = int(input())
edges = []
stars = []
for _ in range(n):
    x,y = map(float,input().split())
    stars.append((x,y))

for i in range(n-1):
    for j in range(i+1,n):
        x1,y1 = stars[i]
        x2,y2 = stars[j]
        edges.append((round(((x1-x2)**2+(y1-y2)**2)**0.5,3),i,j))
edges.sort()
parent = [i for i in range(n+1)]
result = 0
for edge in edges:
    cost,x,y = edge

    if find_parent(x) != find_parent(y):
        union(x,y)
        result += cost
    
print(round(result,2))