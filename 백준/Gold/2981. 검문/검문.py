n = int(input())
num = sorted([int(input()) for _ in range(n)])
re_num = []

for i in range(1,n):
    re_num.append(num[i]-num[i-1])

def findGCD(a,b):
    if b>a:
        a,b = b,a
    while b>0:
        a,b = b,a%b
    return a

GCD = re_num[0]
for idx in range(1,len(re_num)):
    GCD = findGCD(GCD,re_num[idx])

result = set()
for i in range(2,int(GCD**0.5)+1):
    if GCD%i == 0:
        result.add(i)
        result.add(GCD//i)

result.add(GCD)
print(*sorted(list(result)))

