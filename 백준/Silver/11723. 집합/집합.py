import sys
input = sys.stdin.readline

m = int(input())
sett = set()

for _ in range(m):
    s = input().strip()
    if s[:3] == "add":
        _,n = map(str,s.split())
        sett.add(int(n))
    elif s[:6] == "remove":
        _,n = map(str,s.split())
        if int(n) in sett:
            sett.remove(int(n))
    elif s[:5]=="check":
        _,n = map(str,s.split())
        if int(n) in sett:
            print(1)
        else:
            print(0)
    elif s[:6] =="toggle":
        _,n = map(str,s.split())
        if int(n) in sett:
            sett.remove(int(n))
        else:
            sett.add(int(n))
    elif s[:3] == "all":
        sett = set({i for i in range(1,21)})
    else:
        sett = set()
