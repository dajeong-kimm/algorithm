n = int(input())

pn = [0 for i in range(n+5)]
pn[1] = 1
pn[2] = 1
pn[3] = 2
pn[4] = 3

for i in range(5,n+1):
    pn[i] = pn[i-1]+pn[i-2]

print(pn[n])



