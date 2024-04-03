arr = list(map(int,input().split()))
x = 2
while True:
    count = 0
    for a in arr:
        if x%a == 0:
            count += 1
    if count >=3:
        answer = x
        break
    else:
        x += 1

print(answer)