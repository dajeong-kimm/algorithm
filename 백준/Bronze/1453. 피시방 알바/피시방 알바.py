n = int(input())
arr = list(map(int,input().split()))

pc = []
answer = 0
for a in arr:
    if a in pc:
        answer += 1
    elif a not in pc:
        pc.append(a)
print(answer)