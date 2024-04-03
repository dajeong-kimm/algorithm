n = int(input())

km = list(map(int,input().split()))
liter = list(map(int,input().split()))

minPrice = liter[0]
total = 0

for i in range(n-1):
    if minPrice>liter[i]:
        minPrice=liter[i]
    
    total += (minPrice*km[i])

print(total)