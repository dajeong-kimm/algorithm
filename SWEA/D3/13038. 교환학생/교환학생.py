t = int(input())

for test_case in range(1,t+1):
    n = int(input())
    arr = list(map(int,input().split()))
    answer = int(1e9)
    cnt = 0
    for i in range(7):
        if arr[i] == 1:
            time = 0
            cnt = 0
            new_arr = arr[i:]+arr[:i]
            break_point = False
            while True:
                for i in range(7):
                    time += 1
                    if new_arr[i] == 1:
                        cnt += 1
                    if cnt == n:
                        answer = min(answer,time)
                        break_point = True
                        break
                if break_point:
                    break
    print(f"#{test_case} {answer}")
