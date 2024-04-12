n,m = map(int,input().split())
money = [int(input()) for _ in range(n)]

start = min(money)
end = sum(money)

while start<=end:
    count = 1
    mid = (start+end)//2
    tmp = mid

    for mo in money:
        if tmp<mo:
            count += 1
            tmp = mid
        tmp -= mo
    if count>m or mid<max(money):
        start = mid+1
    elif count<=m:
        end = mid-1
        k = mid

print(k)


