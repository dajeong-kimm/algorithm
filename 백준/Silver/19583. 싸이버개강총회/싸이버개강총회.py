import sys
input = sys.stdin.readline
s,e,q = input().split()

start = int(s[:2]+s[3:])
end = int(e[:2]+e[3:])
stream = int(q[:2]+q[3:])

attend = set()
cnt = 0
while True:
    try:
        a,b = input().split()
        a = int(a[:2]+a[3:])
        if a<=start:
            attend.add(b)
        elif end<=a<=stream and b in attend:
            attend.remove(b)
            cnt += 1
    except:
        break

print(cnt)