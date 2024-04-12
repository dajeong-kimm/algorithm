import sys
def check(i,j,visited):
    for idx in range(4):
        ni = i+d[idx][0]
        nj = j + d[idx][1]
        if (ni,nj) in visited:
            return False
    return True

def dfs(visited,total):
    global answer
    if total>=answer:
        return
    if len(visited) == 15:
        answer = min(answer,total)
    else:
        for i in range(1,n-1):
            for j in range(1,n-1):
                if check(i,j,visited) and (i,j) not in visited:
                    temp = [(i,j)]
                    temp_cost = fields[i][j]
                    for idx in range(4):
                        ni = i+d[idx][0]
                        nj = j+d[idx][1]
                        temp.append((ni,nj))
                        temp_cost += fields[ni][nj]
                    dfs(visited+temp, total+temp_cost)

d = [(-1,0),(1,0),(0,-1),(0,1)]

n = int(input())
answer = sys.maxsize
fields = [list(map(int,input().split())) for _ in range(n)]
dfs([],0)

print(answer)
