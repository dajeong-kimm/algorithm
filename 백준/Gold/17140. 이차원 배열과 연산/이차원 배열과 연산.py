r,c,k = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(3)]

def sort_new(matrix,RC):
    sorted_matrix = []
    max_count = 0

    for i in range(len(matrix)):
        B = []
        dic = dict()
        for j in range(len(matrix[i])):
            if matrix[i][j] != 0:
                if matrix[i][j] not in dic:
                    dic[matrix[i][j]] = 1
                else:
                    dic[matrix[i][j]] += 1
        for key,value in dic.items():
            B.append([key,value])
        B.sort(key=lambda x:[x[1],x[0]])
        C = sum(B,[])
        max_count = max(max_count,len(C))
        sorted_matrix.append(C)
    for i in sorted_matrix:
        i += [0]*(max_count-len(i))
        if len(i)>100:
            i = i[:100]
    return sorted_matrix if RC == "R" else list(zip(*sorted_matrix))

result = 0
while True:
    count = 0
    if result>=101:
        result = -1
        break

    if r-1<len(a) and c-1<len(a[0]):
        if a[r-1][c-1] == k:
            break

    if len(a)>=len(a[0]):
        a = sort_new(a,"R")
    else:
        a = sort_new(list(zip(*a)),"C")
    result += 1

print(result)