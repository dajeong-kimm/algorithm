def count_deadlock(tmp):
    result = 0
    before = "white"
    dict = {1:"red",2:"blue"}
    for t in tmp:
        if before == "red" and dict[t] == "blue":
            result += 1
        before = dict[t]
    return result
        

for test_case in range(1,11):
    n = int(input())
    answer = 0
    arr = [list(map(int,input().split())) for _ in range(100)]
    for i in range(100):
        tmp = []
        for j in range(100):
            if arr[j][i] != 0:
                tmp.append(arr[j][i])
        answer += count_deadlock(tmp)
    print(f"#{test_case} {answer}")
