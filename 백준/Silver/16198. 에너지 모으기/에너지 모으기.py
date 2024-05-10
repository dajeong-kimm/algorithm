n = int(input())
arr = list(map(int,input().split()))
answer = 0
def dfs(arr,tmp):
    global answer
    if len(arr) == 2:
        answer = max(answer,tmp)
    for i in range(1,len(arr)-1):
        tmpp = arr[i-1]*arr[i+1]
        num = arr[i]
        arr.pop(i)
        dfs(arr,tmp+tmpp)
        arr.insert(i,num)

dfs(arr,0)
print(answer)