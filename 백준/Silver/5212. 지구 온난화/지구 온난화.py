import copy

r,c = map(int,input().split())
graph = []
for _ in range(r):
    graph.append(list(input()))

result = copy.deepcopy(graph)

land_cnt = 0
dx = [0,0,-1,1]
dy = [-1,1,0,0]

for i in range(r):
    for j in range(c):
        if graph[i][j] == "X":
            cnt = 0
            land_cnt += 1
            for z in range(4):
                nx = i+dx[z]
                ny = j+dy[z]

                if 0>nx or nx>=r or 0>ny or ny>=c:
                    cnt += 1
                elif graph[nx][ny] == ".":
                    cnt += 1
            if cnt>=3:
                result[i][j] = "."
                land_cnt -= 1

if land_cnt == 0:
    print("X")
else:
    startR = 0
    endR = 0
    for i in range(r):
        if 'X' in result[i]:
            startR = i
            break
    for i in range(r-1,-1,-1):
        if 'X' in result[i]:
            endR = i
            break

    idx = []
    for j in range(c):
        for i in range(startR,endR+1):
            if 'X' == result[i][j]:
                idx.append(j)
    for i in result[startR:endR+1]:
        print(''.join(i[idx[0]:idx[-1]+1]))