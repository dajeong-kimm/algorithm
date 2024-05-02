a = []
for _ in range(4):
    a.append(int(input()))
b = []
for _ in range(2):
    b.append(int(input()))

a.sort(reverse=True)
b.sort(reverse=True)
answer = sum(a[:3])+b[0]
print(answer)