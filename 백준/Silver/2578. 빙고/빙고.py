arr = [list(map(int,input().split())) for _ in range(5)]

bingo = []
for _ in range(5):
    tmp = list(map(int,input().split()))
    bingo.extend(tmp)

def is_bingo():
    count = 0
    for a in arr:
        if a.count(0)==5:
            count += 1

    for i in range(5):
        tmp = 0
        for j in range(5):
            if arr[j][i] ==0:
                tmp += 1
        if tmp==5:
            count += 1

    d1 = 0
    for i in range(5):
        if arr[i][i] == 0:
            d1 += 1
    if d1 == 5:
        count += 1
    d2 = 0
    for i in range(5):
        if arr[i][4-i] == 0:
            d2 += 1
    if d2==5:
        count +=1
    
    return count
            

for i in range(25):
    bin = bingo[i]
    for x in range(5):
        for y in range(5):
            if bin == arr[x][y]:
                arr[x][y] = 0
    if i>= 11 and is_bingo()>=3:
        print(i+1)
        break