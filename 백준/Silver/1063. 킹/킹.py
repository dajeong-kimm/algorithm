import sys
king, stone, N = sys.stdin.readline().split()
#킹의 이동 방향
move = {'R':(0,1), 'L':(0,-1), 'B':(1,0), 'T':(-1,0), 'RT':(-1,1), 'LT':(-1,-1), 'RB':(1,1), 'LB':(1,-1)}
chess = ['A', 'B' ,'C', 'D', 'E', 'F', 'G', 'H'] # 가로 위치
k1, k2 = (8-(int(king[1])),chess.index(king[0])) # 킹의 열, 행
s1, s2 = (8-(int(stone[1])),chess.index(stone[0])) # 돌의 열, 행
for _ in range(int(N)):
    a, b = move[sys.stdin.readline().strip()]
    if 0 <= k1+a < 8 and 0 <= k2+b < 8: # 킹이 범위 밖을 벗어나지 않으면
        k1, k2 = k1 + a, k2 + b # 킹 이동해보고
        if k1 == s1 and k2 == s2: #그 때 돌과 킹의 위치가 같아지면
            s1, s2 = s1 + a, s2 + b # 돌도 킹과 같은 방향으로 이동
    if s1 <0 or s1 >= 8 or s2 <0 or s2 >= 8: # 만약 돌을 옮겨서 범위를 벗어나면
        k1, k2 = k1 -a, k2 - b # 킹 원위치
        s1, s2 = s1 -a, s2 - b # 돌도 원위치
print(chess[k2], 8-k1,sep='')
print(chess[s2], 8-s1,sep='')