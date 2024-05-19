
T = int(input())

for test_case in range(1, T + 1):
    #arr_test=np.zeros((8,8))
    answer = "yes"
    array=[]
    arr_test=[[0 for j in range(8)] for i in range(8)]
    sum_test=[]

    for i in range(8):
        array.append(list(input()))

    for i in range(8):
        for j in range(8):
            if array[i][j] == 'O':
                arr_test[i][j] = 1
                
    for i in range(8):
        a=0
        b=0
        for j in range(8):
            a += arr_test[i][j]
            b += arr_test[j][i]
        sum_test.append(a)
        sum_test.append(b)

    for i in sum_test:
        if i != 1 or sum(sum_test) != 16:
            answer ="no"

    print("#",test_case," ",answer,sep="")