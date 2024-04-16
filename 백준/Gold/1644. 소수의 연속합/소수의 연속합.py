def prime(num):
    arr = []
    if num == 1:
        return []
    for i in range(2,num+1):
        flag = True
        for j in range(2,int(i**0.5)+1):
            if i%j == 0:
                flag = False
                break
        if flag==True:
            arr.append(i)
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

        