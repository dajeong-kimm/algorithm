def prime(num):
    arr = []
    a = [False,False] + [True]*(n-1)
    
    for i in range(2,n+1):
        if a[i]:
            arr.append(i)
            for j in range(2*i,n+1,i):
                a[j] = False
    return arr

n = int(input())
arr = prime(n)

answer = 0
start,end = 0,0

while end<=len(arr):
    temp_sum = sum(arr[start:end])
    if temp_sum == n:
        answer += 1
        end += 1
    elif temp_sum<n:
        end += 1
    else:
        start += 1

print(answer)

        