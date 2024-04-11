from collections import deque
import sys
input = sys.stdin.readline

n= int(input())
arr = list(map(int,input().split()))
visited = [-1]*(n)
def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 0
    while queue:
        x = queue.popleft()
        for i in range(1,arr[x]+1):
            if x+i<n:
                if visited[x+i] == -1:
                    queue.append(x+i) 
                    visited[x+i] = visited[x]+1

bfs(0)
print(visited[n-1])
