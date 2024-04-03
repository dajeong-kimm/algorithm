t = int(input())

arr = [i for i in range(101)]
arr[1] = 1
arr[2] = 1
arr[3] = 1
arr[4] = 2
arr[5] = 2
arr[6] = 3
arr[7] = 4
arr[8] = 5
arr[9] = 7
arr[10] = 9

for i in range(11,101):
    arr[i] = arr[i-1]+arr[i-5]

for _ in range(t):
    n = int(input())
    print(arr[n])
