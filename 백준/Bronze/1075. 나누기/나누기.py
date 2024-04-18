n = int(input())
f = int(input())

start = n-(n%100)

while True:
    if start%f == 0:
        break
    start += 1

print(str(start)[-2:])
