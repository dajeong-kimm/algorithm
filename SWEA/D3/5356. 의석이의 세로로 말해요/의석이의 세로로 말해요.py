t = int(input())

for test_case in range(1,t+1):
    arr = [list(input()) for _ in range(5)]
    answer = ""
    len_arr = []
    for a in arr:
        len_arr.append(len(a))
    max_len = max(len_arr)
    for i in range(max_len):
        for j in range(5):
            if len_arr[j]>i:
                answer += arr[j][i]
    print(f"#{test_case} {answer}")