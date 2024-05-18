for test_case in range(1,11):
    n = int(input())
    code = list(input().split())
    m = int(input())
    command = list(input().split())
    idx = 0
    while idx<len(command):
        com = command[idx]
        idx += 1
        if com == "I":
            x = command[idx]
            idx += 1
            y = command[idx]
            idx += 1
            if int(x)<20:
                for i in range(int(y)):
                    tmp = command[idx]
                    idx += 1
                    code.insert(int(x)+i,tmp)

        elif com == "D":
            x = command[idx]
            idx += 1
            y = command[idx]
            idx += 1
            if int(x)<20:
                for i in range(int(y)):
                    code.pop(int(x))
    answer = code[:10]
    print(f"#{test_case}",end=" ")
    print(*answer)