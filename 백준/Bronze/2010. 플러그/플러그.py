import sys
n = int(input())
answer = 0
for _ in range(n):
    answer += int(sys.stdin.readline().rstrip())
print(answer-n+1)