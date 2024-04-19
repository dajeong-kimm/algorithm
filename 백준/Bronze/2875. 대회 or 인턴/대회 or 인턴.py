m,n,k = map(int,input().split())

k -= m%2
while k>0:
    if m//2>n:
        k -= 2
        m -= 2
    elif m//2<n:
        k -= 1
        n -= 1
    else:
        k -= 3
        m -= 2
        n -= 1

print(min(m//2,n))