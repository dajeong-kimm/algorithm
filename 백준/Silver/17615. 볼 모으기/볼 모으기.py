n = int(input())
a = input()

red = a.count('R')
blue = n-red
ans = min(red,blue)
cnt = 0

for i in range(n):
    if a[i] != a[0]:
        break
    cnt += 1

if a[0] == "R":
    ans = min(ans, red-cnt)
else:
    ans = min(ans, blue-cnt)

cnt = 0
for i in range(n-1,-1,-1):
    if a[i] != a[n-1]:
        break
    cnt += 1
if a[n-1] == "R":
    ans = min(ans,red-cnt)
else:
    ans = min(ans,blue-cnt)
print(ans)