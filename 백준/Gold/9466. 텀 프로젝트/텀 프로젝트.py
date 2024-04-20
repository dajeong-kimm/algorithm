import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
# 1 2 3 4 5 6 7
# 3 1 3 7 3 4 6
def dfs(i):
    global team_mems

    visited[i] = True # 지목한 사람부터
    team.append(i) # 팀 후보에 추가
    select = selected[i] # 다음 사람 지목

    # 지목한 사람을 이미 방문했을 경우, 그 사람이 팀 후보에 있다면
    if visited[select]:
        if select in team:
            # 그 사람 이후부터 팀에 들어온 사람들은 한 팀
            team_mems += len(team[team.index(select):])
    # 지목한 사람을 방문하지 않았을 경우,
    # 지목 받은 사람이 다른 사람을 지목
    else:
        dfs(select)

t = int(input())

for _ in range(t):
    n = int(input())
    selected = [0] + list(map(int,input().split()))

    visited = [False]*(n+1)
    team_mems = 0

    for i in range(1,n+1):
        if not visited[i]:
            team = []
            dfs(i)
    print(n-team_mems)

    
