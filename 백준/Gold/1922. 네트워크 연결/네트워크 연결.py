n = int(input())
m = int(input())

edges = []
for _ in range(m):
    a,b,c = map(int,input().split())
    edges.append((c,a,b))

edges.sort(key=lambda x:x[0])

parent = [i for i in range(n+1)]

def get_parent(x):
    if parent[x] == x:
        return x
    else:
        parent[x] = get_parent(parent[x])
    return parent[x]

def union(a,b):
    a = get_parent(a)
    b = get_parent(b)

    if a>b:
        parent[a] = b
    else:
        parent[b] = a

def same_parent(a,b):
    return get_parent(a) == get_parent(b)

answer = 0
for cost,a,b in edges:
    if not same_parent(a,b):
        union(a,b)
        answer += cost

print(answer)


