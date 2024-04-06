import math
x,y = map(int,input().split())

if x==y:
    print(-1)
    exit()


start = (y*100)//x
if start>=99:
    print(-1)
    exit()
new = (start+1)

n = math.ceil((new*x-y*100)/(100-new))
print(n)


#print(int(47/53*100))