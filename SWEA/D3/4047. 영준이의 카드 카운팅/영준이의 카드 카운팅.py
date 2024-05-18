t = int(input())

for test_case in range(1,t+1):
    card = input()
    len_card = len(card)//3
    S = []
    D = []
    H = []
    C = []
    answer = [0,0,0,0]
    error = False
    for i in range(len_card):
        shape = card[i*3]
        num = card[i*3+1:i*3+3]
        if shape == "S":
            if num in S:
                error = True
                break
            else:
                S.append(num)
        elif shape == "D":
            if num in D:
                error = True
                break
            else:
                D.append(num)
        elif shape == "H":
            if num in H:
                error = True
                break
            else:
                H.append(num)
        elif shape == "C":
            if num in C:
                error = True
                break
            else:
                C.append(num)
    answer[0] = 13-len(S)
    answer[1] = 13-len(D)
    answer[2] = 13-len(H)
    answer[3] = 13-len(C)

    if error:
        print(f"#{test_case} ERROR")
    else:
        print(f"#{test_case}",end=" ")
        print(*answer)


