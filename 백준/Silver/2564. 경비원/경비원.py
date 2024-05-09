x,y = map(int,input().split())
total = 2*(x+y)
n = int(input())
shop = [list(map(int,input().split())) for _ in range(n)]
start_d, start_n = map(int,input().split())
shop_x = []

def make_line(d,n):
    if d == 1:
        return n
    elif d==4:
        return x+n
    elif d==2:
        return x+y+(x-n)
    else:
        return x+y+x+(y-n)

for d,n in shop:
    shop_x.append(make_line(d,n))

start_x = make_line(start_d,start_n)

answer = 0
for n in shop_x:
    tmp1 = abs(start_x-n)
    tmp2 = total-tmp1
    answer += min(tmp1,tmp2)

print(answer)