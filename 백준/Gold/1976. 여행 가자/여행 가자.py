def get_parent(x):
    if parent[x] == x:
        return x
    else:
        parent[x] = get_parent(parent[x])
    return parent[x]

def union(x,y):
    x = get_parent(x)
    y = get_parent(y)
    if x<y:
        parent[y] = x
    else:
        parent[x] = y
    

n = int(input())
m = int(input())

parent = [i for i in range(n)]

for i in range(n):
    link = list(map(int,input().split()))
    for j in range(n):
        if link[j] == 1:
            union(i,j)

parent = [-1] + parent

path = list(map(int,input().split()))
start = parent[path[0]]

for i in range(1,m):
    if parent[path[i]] != start:
        print("NO")
        break
else:
    print("YES")


