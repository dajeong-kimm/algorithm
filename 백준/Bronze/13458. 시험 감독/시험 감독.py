n = int(input())
arr = list(map(int,input().split()))
b,c = map(int,input().split())

answer = 0
for a in arr:
    a -= b
    answer += 1
    if a>0:
        if a%c == 0:
            answer += a//c
        else:
            answer += (a//c)+1

print(answer)