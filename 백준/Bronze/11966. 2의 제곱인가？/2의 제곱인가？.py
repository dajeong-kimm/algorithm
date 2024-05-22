n = int(input())
if n == 0 or n == 1:
    print(1)
    exit()
while n>1:
    if n%2 != 0:
        print(0)
        exit()
    else:
        n /= 2
print(1)
