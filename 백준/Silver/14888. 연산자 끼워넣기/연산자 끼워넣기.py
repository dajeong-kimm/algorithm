import sys

n = int(input())
arr = list(map(int,input().split()))
cnt_list = list(map(int,input().split()))

ans_max = -sys.maxsize
ans_min = sys.maxsize

def dfs(depth,total,plus,minus,multiply,divide):
    global ans_max, ans_min
    if depth == n:
        ans_max = max(total,ans_max)
        ans_min = min(total,ans_min)
        return
    
    if plus:
        dfs(depth+1,total+arr[depth],plus-1,minus,multiply,divide)
    if minus:
        dfs(depth+1,total-arr[depth],plus,minus-1,multiply,divide)
    if multiply:
        dfs(depth+1,total*arr[depth],plus,minus,multiply-1,divide)
    if divide:
        dfs(depth+1,int(total/arr[depth]),plus,minus,multiply,divide-1)

dfs(1,arr[0],cnt_list[0],cnt_list[1],cnt_list[2],cnt_list[3])
print(ans_max)
print(ans_min)