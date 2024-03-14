def dfs(cur_k, cnt, dungeons, visited):
    max_answer = cnt
    
    for i in range(len(dungeons)):
        if cur_k >= dungeons[i][0] and visited[i] == 0:
            visited[i] = 1
            max_answer = max(max_answer, dfs(cur_k-dungeons[i][1], cnt+1, dungeons, visited))
            visited[i] = 0
    return max_answer

def solution(k, dungeons):
    visited = [0] * len(dungeons)
    answer = dfs(k, 0, dungeons, visited)
    return answer