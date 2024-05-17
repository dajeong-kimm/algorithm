for test_case in range(1,11):
    n = int(input())
    arr = list(map(str,input().split()))
    m = int(input())
    command = list(map(str,input().split()))
    idx = 0
    while idx<len(command):
        com = command[idx]
        idx += 1
        if com == "I":
            x = int(command[idx])
            idx += 1
            y = int(command[idx])
            for i in range(y):
                idx += 1
                tmp = command[idx]
                arr.insert(x+i,tmp)

        elif com == "D":
            x = int(command[idx])
            idx += 1
            y = int(command[idx])
            for i in range(y):
                arr.pop(x)
        elif com == "A":
            y = int(command[idx])
            for _ in range(y):
                idx += 1
                tmp = command[idx]
                arr.append(tmp)
        idx += 1
    arr = arr[:10]
    print(f"#{test_case} ",end="")
    print(*arr)
    

        
