number = list(map(int,input().split()))
total = 0

for num in number:
    total += num**2
print(total%10)