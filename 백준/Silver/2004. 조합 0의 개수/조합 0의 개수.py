n,m = map(int,input().split())

def count2(n):
    if n<2:
        return 0
    count = 0
    while n>=2:
        count += (n//2)
        n = n//2
    return count

def count5(n):
    if n<5:
        return 0
    count = 0
    while n>=5:
        count += n//5
        n = n//5
    return count

two_count = count2(n) - count2(n-m) - count2(m)
five_count = count5(n) - count5(n-m) - count5(m)

print(min(two_count,five_count))