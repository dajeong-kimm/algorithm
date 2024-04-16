n = int(input())

arr1 = []
arr2 = []
for _ in range(n):
    a,b = map(int,input().split())
    arr1.append(a)
    arr2.append(b)

arr1.append(arr1[0])
arr2.append(arr2[0])

sum1,sum2 = 0,0
for i in range(n):
    sum1 += (arr1[i]*arr2[i+1])
    sum2 += (arr2[i]*arr1[i+1])

print(round(abs(sum1-sum2)/2,2))