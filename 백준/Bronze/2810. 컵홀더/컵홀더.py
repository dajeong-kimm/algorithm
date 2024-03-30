n = int(input())
seat = list(input())
i = 0
answer = 1
while i<n:
    if seat[i]=="S":
        answer += 1
        i += 1
    else:
        answer += 1
        i += 2

print(min(answer,n))
