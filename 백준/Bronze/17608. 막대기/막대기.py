n = int(input())
arr = [int(input()) for _ in range(n)]

answer = 0
start = arr.pop()
while arr:
    tmp = arr.pop()
    if tmp>start:
        answer += 1
        start = tmp
print(answer+1)