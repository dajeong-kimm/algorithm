t = int(input())

for _ in range(t):
    l,n = map(int,input().split())
    ant = [int(input()) for _ in range(n)]
    ant.sort()
    min_time = 0
    max_time = 0
    for a in ant:
        min_time = max(min_time,min(a,l-a))
        max_time = max(max_time,a,l-a)
    print(min_time, max_time)
