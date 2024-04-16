b = []
d = []
for _ in range(3):
    b.append(int(input()))
for _ in range(2):
    d.append(int(input()))

b.sort()
d.sort()

print(b[0]+d[0]-50)