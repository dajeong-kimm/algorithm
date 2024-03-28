while True:
    num = list(input())
    if len(num)==1 and num[0]=="0":
        break
    pailn = True
    for i in range(len(num)//2+1):
        if num[i] != num[-1-i]:
            pailn = False
            break
    if pailn:
        print("yes")
    else:
        print("no")