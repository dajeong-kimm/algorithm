def get_parent(x):
    if x!=parent[x]:
        parent[x] = get_parent(parent[x])
    return parent[x]

def union(a,b):
    a = get_parent(a)
    b = get_parent(b)
    if a!=b:
        parent[b] = a
        number[a] += number[b]
    print(number[a])

t = int(input())
for _ in range(t):
    num = int(input())
    parent, number = {},{}
    for i in range(num):
        a,b = input().split()
        if a not in parent:
            parent[a] = a
            number[a] = 1

        if b not in parent:
            parent[b] = b
            number[b] = 1
        union(a,b)
