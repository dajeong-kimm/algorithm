def solution(board):
    ROW, COL = len(board), len(board[0])
    
    # 각 행과 열을 순회하며 최적의 정사각형 찾기
    for i in range(1, ROW):
        for j in range(1, COL):
            # 현재 위치의 값이 1인 경우를 확인
            if board[i][j] == 1:
                up, left, up_left = (
                board[i-1][j], board[i][j-1], board[i-1][j-1]
                )
                # 현재 위치의 값을 이전 위치들의 값들 중 가장 작은 값에 1을 더한 값으로 업데이트
                board[i][j] = min(up, left, up_left) + 1
                
    max_val = max(max(row) for row in board)
    
    return max_val**2
                