num = list(map(int,input().split()))

while True:
    for i in range(4):
        if num[i]>num[i+1]:
            tmp = num[i]
            num[i] = num[i+1]
            num[i+1] = tmp

            for n in num:
                print(n,end=" ")
            print()
    if num == [1,2,3,4,5]:
        break
        


# num = [1,2,3,4,5]
# num[0],num[1] = num[1],num[0]
# print(num)
