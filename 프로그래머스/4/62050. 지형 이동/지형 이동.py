from heapq import heappush, heappop

def solution(land, height):
    answer = 0
    n = len(land)
    
    di = [-1,0,1,0]
    dj = [0,1,0,-1]
    visited = [[False]*n for _ in range(n)]
    
    # 시작 노드 추가
    q = []
    heappush(q, [0,0,0]) # [비용,i,j]
    
    # BFS + 우선순위큐로 다음 노드 관리
    while q:
        cost, i, j = heappop(q)
        
        # 아직 방문하지 않은 경로만 탐색
        if not visited[i][j]:
            visited[i][j] = True
            
            #현재까지 비용을 합산
            answer += cost
            for d in range(4):
                ni, nj = i+di[d], j+dj[d]
                # 유효한 인덱스일 경우
                if 0<=ni<n and 0<=nj<n:
                    temp_cost = abs(land[i][j]-land[ni][nj])
                    # 입력으로 주어진 height보다 높이차가 큰 경우
                    if temp_cost>height:
                        new_cost = temp_cost
                    else:
                        new_cost = 0
                    
                    # 다음 경로를 푸시
                    heappush(q, [new_cost,ni,nj])
    return answer