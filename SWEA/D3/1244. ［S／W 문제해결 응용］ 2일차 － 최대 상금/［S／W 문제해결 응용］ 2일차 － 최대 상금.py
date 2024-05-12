def dfs(arr,cnt):
    global answer
    global result
    if cnt == k:
        if int(''.join(arr))>answer:
            answer = int(''.join(arr))
        return
    for i in range(len(s)-1):
        for j in range(i+1,len(s)):
            arr[i],arr[j] = arr[j],arr[i]
            tmp_key = ''.join(arr)
            if visited.get((tmp_key,cnt+1),1):
                visited[(tmp_key,cnt+1)] = 0
                dfs(arr,cnt+1)
            arr[i],arr[j] = arr[j],arr[i]

t = int(input())
for test_case in range(1,t+1):
    s,k = map(str,input().split())
    s = list(s)
    k = int(k)
    answer = 0
    visited = {}
    dfs(s,0)
    print(f"#{test_case} {answer}")