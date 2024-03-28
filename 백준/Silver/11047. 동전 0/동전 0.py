n, k = map(int,input().split())

coin = []
for _ in range(n):
    coin.append(int(input()))
max_coin_idx = n
for i in range(n):
    if coin[i]>k:
        max_coin_idx = i-1

coin = coin[:max_coin_idx]

answer = 0
while k>0:
    answer += (k//coin[-1])
    k = k%coin[-1]
    coin.pop()

print(answer)