n,s = map(int,input().split())

arr = list(map(int,input().split()))

cnt = 0
ans = []

def solve(start):
    global cnt
    if sum(ans) == s and len(ans)>0:
        cnt += 1

    for i in range(start,n):
        ans.append(arr[i])
        solve(i+1)
        ans.pop()
solve(0)
print(cnt)