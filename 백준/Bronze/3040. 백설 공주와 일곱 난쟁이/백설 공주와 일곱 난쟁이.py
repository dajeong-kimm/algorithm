from itertools import combinations
arr = [int(input()) for _ in range(9)]

for com in combinations(arr,7):
    tmp = 0
    for c in com:
        tmp += c
    if tmp == 100:
        for c in com:
            print(c)
        break
