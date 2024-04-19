import copy
def num_matrix(arr1,arr2):
    new_arr = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                new_arr[i][j] += (arr1[i][k]*arr2[k][j])%1000
            new_arr[i][j] %= 1000
    return new_arr

n,b = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

def square(A,B):
    if B == 1:
        for x in range(len(A)):
            for y in range(len(A)):
                A[x][y] %= 1000
        return A
    tmp = square(A,B//2)
    if B%2:
        return num_matrix(num_matrix(tmp,tmp),A)
    else:
        return num_matrix(tmp,tmp)

result = square(arr,b)
for r in result:
    print(*r)
    
