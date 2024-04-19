import heapq
import sys
input = sys.stdin.readline

def get_parent(x):
    if x == parent[x]:
        return x
    parent[x] = get_parent(parent[x])
    return parent[x]

def union(a,b):
    a = get_parent(a)
    b = get_parent(b)

    if a>b:
        parent[a] = b
    else:
        parent[b] = a

n,m = map(int,input().split())

edges = []
parent = list(range(n+1))

for _ in range(m):
    a,b,c = map(int,input().split())
    edges.append((a,b,c))
edges.sort(key = lambda x:x[2])

answer = 0
last_edge = 0
for a,b,c in edges:
    if get_parent(a) != get_parent(b):
        union(a,b)
        answer += c
        last_edge = c

print(answer-last_edge)

# def is_cycle(m):
#     if sum(parent[1:])//n == parent[1] and m == n:
#         return True
#     return False

# n,m = map(int,input().split())
# parent = [i for i in range(n+1)]
# distances = [[float("inf")]*(n+1) for _ in range(n+1)]

# heap = []*(n+1)
# for _ in range(m):
#     a,b,c = map(int,input().split())
#     heap.append((c,a,b))

# heapq.heapify(heap)
# total_cost = 0
# connected = 0
# max_cost = 0
# while heap:
#     cost,a,b = heapq.heappop(heap)
#     if get_parent(a) != get_parent(b):
#         union(a,b)
#         total_cost += cost
#         max_cost = max(max_cost,cost)
#         connected += 1
#         if is_cycle(connected):
#             break

# print(total_cost-max_cost)



