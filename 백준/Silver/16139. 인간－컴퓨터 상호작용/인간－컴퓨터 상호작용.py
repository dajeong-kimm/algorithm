import sys
input = sys.stdin.readline

s = list(input().rstrip())
q = int(input())
for _ in range(q):
    a,start,end = map(str,input().split())
    start,end = int(start), int(end)

    answer = s[start:end+1].count(a)
    print(answer)