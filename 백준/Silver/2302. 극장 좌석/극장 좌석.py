n = int(input())
m = int(input())
seat = []
for _ in range(m):
    seat.append(int(input()))



def dp_num(num):
    dp = [0]*(41)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    if num>=3:
        for i in range(3,num+1):
            dp[i] = dp[i-2]+dp[i-1]
    return dp[num]

if m == 0:
    print(dp_num(n))
    exit()

arr = []
tmp = 1
for s in seat:
    arr.append(s-tmp)
    tmp = s+1

if len(arr) < m+1:
    arr.append(n-seat[-1])

answer = 1
for a in arr:
    if a!=0:
        answer *= dp_num(a)
print(answer)