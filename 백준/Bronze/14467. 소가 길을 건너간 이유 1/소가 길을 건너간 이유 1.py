dict = {}

n = int(input())
cnt = 0
for i in range(n):
    a, b = map(int,input().split())
    if a not in dict:
        dict[a] = b
    else:
        if dict[a] != b:
            cnt += 1
            
        dict[a] = b
print(cnt)