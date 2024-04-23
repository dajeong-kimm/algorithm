from collections import deque
INF = int(1e9)

def combinations(array,cnt):
    result = []
    if cnt == 0:
        return [[]]
    for i in range(len(array)):
        elementary = array[i]
        rest_array = array[i+1:]
        for c in combinations(rest_array,cnt-1):
            result.append([elementary]+c)
    return result

def is_connected(nodes):
    queue = deque()
    check = [False for _ in range(n)]
    queue.append(nodes[0])
    check[nodes[0]] = True

    while queue:
        node = queue.popleft()
        for i in range(len(arr[node])):
            if arr[node][i] == 0:
                continue
            if i not in nodes:
                continue
            if not check[i]:
                check[i] = True
                queue.append(i)
    return check.count(True) == len(nodes)

def get_total(nodes):
    total = 0
    for node in nodes:
        total += people[node]
    return total

n = int(input())
people = list(map(int,input().split()))
arr = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    _, *dsts = map(int,input().split())
    for dst in dsts:
        arr[i][dst-1] = 1

cases = []
X = {i for i in range(n)}
ans = INF

for i in range(1,n//2+1):
    As = tuple(combinations(list(X),i))
    for A in As:
        B = list(X.difference(A))

        if is_connected(A) and is_connected(B):
            a_total = get_total(A)
            b_total = get_total(B)
            ans = min(ans,abs(a_total-b_total))

if ans == INF:
    print(-1)
else:
    print(ans)