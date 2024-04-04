#  반드시 저장된 사이트의 주소가 입력됨

n,m = map(int,input().split())
dict = {}
for _ in range(n):
    a,b = map(str,input().split())
    dict[a] = b

for _ in range(m):
    tmp = input()
    print(dict[tmp])