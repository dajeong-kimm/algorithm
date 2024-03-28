import sys
sys.setrecursionlimit(10*6)
def factorial(n):
    fac = [i for i in range(21)]
    fac[0] = 1
    if n==0 or n==1 or n==2:
        return fac[n]
    else:
        for i in range(3,n+1):
            fac[i] = i*fac[i-1]
    return fac[n]

n = int(input())
print(factorial(n))