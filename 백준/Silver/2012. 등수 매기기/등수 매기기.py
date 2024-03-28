import sys
input = sys.stdin.readline
n = int(input())

score = []
for _ in range(n):
    score.append(int(input()))
score.sort()
answer = 0

for i in range(n):
    answer += abs(i+1-score[i])

print(answer)