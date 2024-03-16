def solution(board, aloc, bloc):
    # 게임판의 행과 열의 개수를 저장
    ROW, COL = len(board), len(board[0])
    
    # 이동할 수 있는 방향을 저장
    DR, DC = [-1,0,1,0],[0,1,0,-1]
    
    # 주어진 위치가 유효한 위치인지 확인
    def is_valid_pos(r,c):
        return 0<=r<ROW and 0<=c<COL

    # 재귀적으로 호출되는 함수
    def recursive_func(alpha_pos, beta_pos, visited, step):
        # 현재 플레이어의 위치와 이동 가능한지 여부, 상대 플레이어가 이긴 경우를 저장
        r, c = alpha_pos if step%2 == 0 else beta_pos
        can_move = False
        is_opponent_winner = True
        
        # 이긴 경우와 지는 경우를 저장하는 리스트
        win_steps, lose_steps = [], []
        
        # 현재 위치에서 이동할 수 있는 모든 방향으로 이동
        for i in range(4):
            nr, nc = r+DR[i], c+DC[i]
            # 이동할 수 있는 위치인 경우
            if is_valid_pos(nr,nc) and (nr,nc) not in visited and board[nr][nc]:
                can_move=True
                # 두 플레이어의 위치가 같으면 A 플레이어가 이긴 것이므로 True와 step+1을 반환
                if alpha_pos == beta_pos:
                    return True, step+1
                
                # 재귀적으로 호출하여 이긴 여부와 남은 턴 수를 가져옴
                win, steps_left = (
                    recursive_func([nr,nc],beta_pos,visited | {(r,c)}, step+1) 
                    if step%2 == 0 
                    else recursive_func(
                        alpha_pos, [nr,nc],visited | {(r,c)}, step+1
                    )
                )
                
                # 상대 플레이어가 이긴 경우만 True로 유지
                is_opponent_winner &= win
                
                # 이긴 경우와 지는 경우를 저장
                (win_steps if win else lose_steps).append(steps_left)
        # 이동할 수 있는 위치가 없는 경우
        if not can_move:
            return False, step

        # 상대 플레이어가 이긴 경우
        if is_opponent_winner:
            return False, max(win_steps)

        # 현재 플레이어 이긴 경우
        return True, min(lose_steps)
    
    # A 플레이어가 이길 때까지 걸리는 최소 턴 수를 반환
    _, steps = recursive_func(aloc, bloc, set(), 0)
    return steps