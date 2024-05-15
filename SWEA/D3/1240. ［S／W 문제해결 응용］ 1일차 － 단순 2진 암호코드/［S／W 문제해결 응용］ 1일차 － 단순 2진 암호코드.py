t = int(input())

for test_case in range(1,t+1):
    n,m = map(int,input().split())
    arr = [list(input()) for _ in range(n)]
    code = []
    code_change = ["0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"]
    for i in range(n):
        for j in range(m-1,-1,-1):
            if arr[i][j] == "1":
                code = arr[i][j-55:j+1]
                break
    code_num = []
    for i in range(8):
        tmp_list = code[i*7:i*7+7]
        tmp = ''.join(tmp_list)
        change_num = code_change.index(tmp)
        code_num.append(change_num)
    odd = 0
    even = 0
    for i in range(8):
        if i%2 == 0:
            odd += code_num[i]
        else:
            even += code_num[i]

    result = odd*3+even
    answer = 0
    if result%10 == 0:
        answer = sum(code_num)
    print(f"#{test_case} {answer}")
    