n = int(input())

for _ in range(n):
    m = int(input())
    player = []
    for _ in range(m):
        player.append(list(map(str, input().split())))
    player = sorted(player, key = lambda x:int(x[0]),reverse=True)
    print(player[0][1])