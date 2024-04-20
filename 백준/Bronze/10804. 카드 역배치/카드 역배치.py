card = [i for i in range(1,21)]

for _ in range(10):
    a,b = map(int,input().split())
    a -= 1
    b -= 1
    card = card[:a]+card[a:b+1][::-1]+card[b+1:]

print(*card)