n = int(input())

charge = 1000-n
coin = [500,100,50,10,5,1]
answer = 0
i = 0
while charge>0:
    answer += (charge//coin[i])
    charge = charge%coin[i]
    i += 1

print(answer)


