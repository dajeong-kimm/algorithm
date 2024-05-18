decode = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
decode_list = list(decode)
t = int(input())
for test_case in range(1,t+1):
    test = list(input())
    test_str = ''
    for t in test:
        t_num = decode_list.index(t)
        tmp = str(bin(t_num)[2:])
        while len(tmp)<6:
            tmp = '0'+tmp
        test_str += tmp
    answer = ''
    for i in range(len(test)*6//8):
        tmp_num = int(test_str[i*8:i*8+8],2)
        answer += chr(tmp_num)
    print(f"#{test_case} {answer}")