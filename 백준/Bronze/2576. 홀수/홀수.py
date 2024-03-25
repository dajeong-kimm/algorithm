number = []
for _ in range(7):
    num = int(input())
    if num%2 == 1:
        number.append(num)
if not number:
    print(-1)
else:
    print(sum(number))
    print(min(number))