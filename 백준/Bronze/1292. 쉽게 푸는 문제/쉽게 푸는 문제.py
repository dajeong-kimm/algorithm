a, b = map(int,input().split())

num = [0]
count = 0
idx = 1
sum_value = 0
while count<=b:
    for _ in range(idx):
        num.append(idx)
        count += 1
    idx += 1

print(sum(num[a:b+1]))