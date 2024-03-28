import sys
input = sys.stdin.readline

n, m = map(int,input().split())

minimum = []
for _ in range(n):
    # 신청한 사람, 수강인원
    a, b = map(int,input().split())
    mile = list(map(int,input().split()))
    mile.sort(reverse=True)
    if a<b:
        minimum.append(1)
    else:
        minimum.append(mile[b-1])

minimum.sort()
answer = 0
for mi in minimum:
    if mi<=m:
        m -= mi
        answer += 1

print(answer)

