n,k = map(int,input().split())
arr = []
for _ in range(n):
    a,b,c,d = map(int,input().split())
    arr.append([a,b,c,d])

arr.sort(key=lambda x:(-x[1],-x[2],-x[3]))

grade, s = 1, 0
for i in range(n):
    if i!=0:
        if arr[i-1][1:]  == arr[i][1:]:
            s += 1
        else:
            if s:
                grade += s
                s = 0
            grade += 1
    if arr[i][0] == k:
        print(grade)
        break