from collections import deque
def bfs():
    queue = deque()
    queue.append([home_x,home_y])
    while queue:
        x,y = queue.popleft()
        if abs(target_x-x)+abs(target_y-y)<=1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                new_x, new_y = graph[i]
                if abs(x-new_x)+abs(y-new_y)<=1000:
                    visited[i] = 1
                    queue.append([new_x,new_y])
    print("sad")
    return


t = int(input())
for _ in range(t):
    n = int(input())
    home_x, home_y = map(int,input().split())
    graph = [list(map(int,input().split())) for _ in range(n)]
    target_x, target_y = map(int,input().split())
    visited = [0 for _ in range(n)]
    bfs()


    
        

