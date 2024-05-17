import copy
t = int(input())
for test_case in range(1,t+1):
    n = int(input())
    print(f"#{test_case}")
    if n == 1:
        print(1)
        continue
    elif n == 2:
        print(1)
        print(1,1)
        continue
    print(1)
    print(1,1)
    num = [1,1]
    for i in range(3,n+1):
        new_num = [1]
        print(1,end=" ")
        for j in range(len(num)-1):
            tmp = num[j]+num[j+1]
            new_num.append(tmp)
            print(tmp,end=" ")
        print(1)
        new_num.append(1)
        num = copy.deepcopy(new_num)
