import copy
t = int(input())
for test_case in range(1,t+1):
    num = int(input())
    max_value, min_value = num, num
    num_str = list(str(num))
    for i in range(len(num_str)-1):
        for j in range(i+1,len(num_str)):
            tmp = copy.deepcopy(num_str)
            if not (i==0 and tmp[j]=='0'):
                tmp[i],tmp[j] = tmp[j],tmp[i]
                tmp_num = int(''.join(tmp))
                max_value = max(max_value,tmp_num)
                min_value = min(min_value,tmp_num)
    print(f"#{test_case} {min_value} {max_value}")