from itertools import permutations
N = int(input())

data = [str(i) for i in range(1,10)]
num = list(permutations(data,3))

for _ in range(N):
    n, s, b = map(int,input().split())
    n = list(str(n))
    rmcnt = 0
    for i in range(len(num)):
        strike = ball = 0
        i -= rmcnt
        for j in range(3):
            if num[i][j] == n[j]:
                strike += 1
            elif n[j] in num[i]:
                ball += 1
        if (strike != s) or (ball != b):
            num.remove(num[i])
            rmcnt += 1

print(len(num))
