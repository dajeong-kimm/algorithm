n = int(input())

q = []

def dfs():
    if len(q) == n:
        print(*q)
        return
    for i in range(1,n+1):
        if i not in q:
            q.append(i)
            dfs()
            q.pop()

dfs()