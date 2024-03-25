n = int(input())

car = list(map(int,input().split()))
answer = 0
for c in car:
    if c == n:
        answer += 1
print(answer)